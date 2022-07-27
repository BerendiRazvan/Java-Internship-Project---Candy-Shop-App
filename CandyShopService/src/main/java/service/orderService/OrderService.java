package service.orderService;

import domain.Customer;
import domain.Shop;
import domain.order.Order;
import domain.order.OrderType;
import domain.sweet.Sweet;
import service.exception.ServiceException;

import java.util.List;

public interface OrderService {

    Order createOrder(Customer customer, OrderType orderType, Shop shop) throws ServiceException;

    void addToOrder(Order order, Sweet newSweet) throws ServiceException;

    String getOrderDetails(long orderId);

    void removeOrder(long idOrder) throws ServiceException;

    List<Order> getAllOrdersInADay();

    double getMoneyMadeToday();

    double getProfitMadeToday();

    String printOrderDetails(String orderId) throws ServiceException;
}
