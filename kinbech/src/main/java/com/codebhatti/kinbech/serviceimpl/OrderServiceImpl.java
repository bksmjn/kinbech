package com.codebhatti.kinbech.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codebhatti.kinbech.domain.Cart;
import com.codebhatti.kinbech.domain.CartItem;
import com.codebhatti.kinbech.domain.Order;
import com.codebhatti.kinbech.domain.ProductCopy;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.exception.BusinessException;
import com.codebhatti.kinbech.repository.OrderRepository;
import com.codebhatti.kinbech.service.AccountService;
import com.codebhatti.kinbech.service.OrderService;
import com.codebhatti.kinbech.service.ProductCopyService;
import com.codebhatti.kinbech.service.UserService;
import com.codebhatti.kinbech.validation.OrderValidator;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AccountService accountService;

	@Autowired
	private OrderValidator orderValidator;
	
	@Autowired
	private ProductCopyService productCopyService;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Order> createOrder(User user, Cart cart) throws BusinessException {
		List<Order> ordersList = new ArrayList<>();
		Map<Long, CartItem> cartMap = cart.getCartItems();
		Iterator<Long> cartIterator = cartMap.keySet().iterator();
		
		while (cartIterator.hasNext()) {
			Long mapKey = cartIterator.next();
			CartItem cartItem = cartMap.get(mapKey);
			
			Order order=new Order();
			
			List<ProductCopy> productCopies = productCopyService.getProductCopiesFromProductId(cartItem.getProductId(), cartItem.getQuantity());
			order.setProductCopy(productCopies);
			order.setBuyer(user);
			order.setQuantity(productCopies.size());
			order.setAmount(productCopies.get(0).getProduct().getUnitPrice() * productCopies.size());
			order.setSeller(userService.findByUserName(productCopies.get(0).getProduct().getSellerId()));
			
			ordersList.add(order);
		}
		
		return ordersList;
	}
	
	@Override
	public boolean processOrder(User user, Cart cart) throws BusinessException {
		List<Order> ordersList = createOrder(user, cart);
		
		for(Order order : ordersList) {
			if (isOrderValid(user, order))
				orderRepository.save(order);
			else
				throw new BusinessException("Order details is not valid");
		}
		
		cart.initialize();
		return true;
	}

	@Override
	public boolean isOrderValid(User user, Order order) {
		return (orderValidator.validateQuantity(order) && orderValidator.validateUserAccountBalance(user, order)
				&& orderValidator.validateUserStatus(user));
	}
}
