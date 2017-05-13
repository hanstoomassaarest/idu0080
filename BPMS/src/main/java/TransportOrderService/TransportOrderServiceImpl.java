package TransportOrderService;


import javax.jws.WebService;

@WebService(endpointInterface = "TransportOrderService.TransportOrderServiceImpl",
        portName = "TransportOrderServicePort",
        serviceName = "TransportOrderService")
public class TransportOrderServiceImpl implements TransportOrderService {


    public String orderTransport(String offerId) {
        try {
            StringBuilder returnVal = new StringBuilder();
            returnVal.append(offerId.toLowerCase());
            returnVal.append("#");
            returnVal.append(formatDate());
            return returnVal +"";
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    private String formatDate() {
        java.util.Date date = new java.util.Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(java.util.Calendar.YEAR);
        int month = cal.get(java.util.Calendar.MONTH);
        int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
        if(month < 10) return year+"0"+month+""+day;
        else if(day<10)return year+""+month+"0"+day;
        else if(month < 10 && day < 10) return year+"0"+month+"0"+day;
        return year+""+month+""+day+"";
    }
}
