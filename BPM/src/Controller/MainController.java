package Controller;

import DTO.FullOffer;
import MyCourierServiceClient.Courier;
import MyCourierServiceClient.MalformedURLException_Exception;
import MyCourierServiceClient.MyCourierService;
import OfferServiceClient.OfferService;
import OfferServiceClient.Seller;
import OrderServiceClient.Address;
import OrderServiceClient.Order;
import OrderServiceClient.OrderService;
import OrderShipmentServiceClient.OrderShipment;
import OrderShipmentServiceClient.OrderShipmentService;
import TransportOrderServiceClient.TransportOrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController {

    /**
     * Order id must be between 1-4 in this test case
     *
     * @param args
     * @throws MalformedURLException_Exception
     */
    public static void main(String[] args) throws MalformedURLException_Exception {
        int orderId = 1;
        if (orderId < 5) {
            Order order = getOrder(orderId);
            printOrder(order);
            List<Courier> couriers = getAllCouriers();
            printCouriers(couriers);
            List<FullOffer> offers = getAllOffers(order, couriers);
            FullOffer bestOffer = getBestFullOffer(offers);
            bestOffer = orderTransport(bestOffer);
            checkOutOrder(bestOffer, orderId);
        }
    }

    private static List<Courier> getAllCouriers() throws MalformedURLException_Exception {
        MyCourierService service = new MyCourierService();
        return service.getMyCourierServicePort().getCouriers();
    }

    private static Order getOrder(int orderId) {
        OrderService orderService = new OrderService();
        return orderService.getOrderServicePort().getOrderById(orderId);
    }

    private static void checkOutOrder(FullOffer offer, int orderId) {
        OrderShipmentService service = new OrderShipmentService();
        OrderShipment shipment = new OrderShipment();
        shipment.setRyhmaName("IDU0080: Saarest, Roopärg, Salumets");
        shipment.setApproximateDeliveryTime(offer.getOffer().getApproximateDeliveryTime());
        shipment.setCourierName(offer.getCourier().getName());
        shipment.setOrderId(orderId);
        shipment.setTrackingNumber(offer.getTrackingCode());
        shipment.setTransportPrice(offer.getOffer().getPrice());
        service.getOrderShipmentServicePort().insertOrderShipment(shipment);

        System.out.println("\nOrder checkout : "
                + "\n Group name: " + shipment.getRyhmaName()
                + "\n Approximate delivery time: " + shipment.getApproximateDeliveryTime()
                + "\n Courier: " + shipment.getCourierName()
                + "\n Order id: " + shipment.getOrderId()
                + "\n Tracking code: " + shipment.getTrackingNumber()
                + "\n Shipping price: " + shipment.getTransportPrice()
        );
    }

    private static List<FullOffer> getAllOffers(Order order, List<Courier> couriers) {
        List<FullOffer> fullOffers = new ArrayList<FullOffer>();
        System.out.println("\nOffers:");
        OfferService offerService = new OfferService();
        for (Courier courier : couriers) {
            OfferServiceClient.TransportServiceOffer offer = offerService.getOfferServicePort().getOffer(courier.getId(), convertOrderToOfferOrder(order));
            double rate = evaluateOffer(offer.getPrice(), offer.getApproximateDeliveryTime());
            System.out.println(courier.getName() +
                    "\n Offer id: " + offer.getOfferId() +
                    "\n Offer price: " + offer.getPrice() +
                    "\n Approximate delivery time: " + offer.getApproximateDeliveryTime() +
                    "\n Offer rate: " + rate +
                    "\n---------------------------");
            FullOffer fullOffer = new FullOffer();
            fullOffer.setCourier(courier);
            fullOffer.setOffer(offer);
            fullOffer.setRate(rate);
            fullOffers.add(fullOffer);
        }
        return fullOffers;
    }

    private static FullOffer orderTransport(FullOffer bestOffer) {
        TransportOrderService transportService = new TransportOrderService();
        String trackingCode = transportService.getTransportOrderServicePort().orderTransport(bestOffer.getOffer().getOfferId());
        System.out.println("Transportation tracking code: " + trackingCode);
        bestOffer.setTrackingCode(trackingCode);
        return bestOffer;
    }

    private static double evaluateOffer(double shippingPrice, int dayAmmount) {
        return shippingPrice * 0.01 * dayAmmount;
    }

    private static FullOffer getBestFullOffer(List<FullOffer> offers) {
        FullOffer bestOffer = null;
        if (offers.isEmpty()) {
            return null;
        }
        for (FullOffer offer : offers) {
            if (Objects.isNull(bestOffer)) {
                bestOffer = offer;
            }
            if (bestOffer.getRate() >= offer.getRate()) {
                bestOffer = offer;
            }
        }
        if (Objects.nonNull(bestOffer.getOffer())) {
            System.out.println("\nBest offer: " + bestOffer.getOffer().getApproximateDeliveryTime() + " days, ID: " + bestOffer.getOffer().getOfferId());
        }
        return bestOffer;
    }

    private static OfferServiceClient.Order convertOrderToOfferOrder(Order order) {
        OfferServiceClient.Order offerOrder = new OfferServiceClient.Order();
        offerOrder.setOrderId(order.getOrderId());

        OfferServiceClient.Address address = new OfferServiceClient.Address();
        address.setAddressId(order.getDeliveryAddress().getAddressId());
        address.setCountry(order.getDeliveryAddress().getCountry());
        address.setCounty(order.getDeliveryAddress().getCounty());
        address.setDepartmentNumber(order.getDeliveryAddress().getDepartmentNumber());
        address.setHouseNumber(order.getDeliveryAddress().getHouseNumber());
        address.setStreet(order.getDeliveryAddress().getStreet());
        offerOrder.setDeliveryAddress(address);
        offerOrder.setOrderCost(order.getOrderCost());

        Seller seller = new Seller();
        List<OfferServiceClient.Address> selAddresses = new ArrayList<OfferServiceClient.Address>();
        for (Address selAddress : order.getSeller().getAddresses()) {
            OfferServiceClient.Address ad = new OfferServiceClient.Address();
            ad.setAddressId(selAddress.getAddressId());
            ad.setCountry(selAddress.getCountry());
            ad.setCounty(selAddress.getCounty());
            ad.setDepartmentNumber(selAddress.getDepartmentNumber());
            ad.setHouseNumber(selAddress.getHouseNumber());
            ad.setStreet(selAddress.getStreet());
            selAddresses.add(ad);
        }
        seller.getAddresses().addAll(selAddresses);
        offerOrder.setSeller(seller);
        return offerOrder;
    }

    private static void printOrder(Order order) {
        Address deAddress = order.getDeliveryAddress();
        System.out.println("Order: " + order.getOrderId());
        System.out.println("Order cost: " + order.getOrderCost());
        System.out.println("Delivery address: " + deAddress.toString());
        System.out.println("Seller addresses:");
        order.getSeller().getAddresses().forEach(address -> System.out.println(" -\t" + address.toString()));
        System.out.println("\n=================\n");
    }

    private static void printCouriers(List<Courier> couriers) {
        System.out.println("All couriers: ");
        couriers.forEach(courier -> System.out.println(courier.getId() + " - " + courier.getName()));
    }
}
