package Lamda;

import java.util.ArrayList;
import java.util.List;

public class ConditionCheck {

	public static void main(String[] args) {

		OrderDO demoOrder = new OrderDO();
		// demoOrder.setStatus(null);

		BusinessMessages businessMessage1 = new BusinessMessages();
		businessMessage1.setMessage("CS_ORDER_BEING_PROCESSED_IN_BATCH_MODE");
		businessMessage1.setCode(1);

		BusinessMessages businessMessage2 = new BusinessMessages();
		businessMessage1.setMessage("CS_ORDER_BEING_PROCESSED_IN_BATCH_MODE");
		businessMessage1.setCode(2);

		demoOrder.setErrors(new ArrayList<>());
		demoOrder.getErrors().add(businessMessage1);
		demoOrder.getErrors().add(businessMessage2);

		demoOrder.getErrors().forEach(businessMessage -> {
			if ("CS_ORDER_BEING_PROCESSED_IN_BATCH_MODE".equals(businessMessage.getMessage())) {
				demoOrder.setStatus("EPS_ERROR");
				demoOrder.setCode(businessMessage.getCode());
			}
		});

//		demoOrder.getErrors().stream().findFirst(businessMessage->{
//        	if("CS_ORDER_BEING_PROCESSED_IN_BATCH_MODE".equals(businessMessage.getMessage())){
//        		demoOrder.setStatus("EPS_ERROR");
//        		demoOrder.setCode(businessMessage.getCode());
//        	}
//        });

		for (BusinessMessages businessMessage : demoOrder.getErrors()) {
			if ("CS_ORDER_BEING_PROCESSED_IN_BATCH_MODE".equals(businessMessage.getMessage())) {

				demoOrder.setStatus("EPS_ERROR");
				demoOrder.setCode(businessMessage.getCode());
				break;
			}
		}

		System.out.println("Order status: " + demoOrder.getStatus());
		System.out.println("Order code: " + demoOrder.getCode());

	}

}

class OrderDO {

	String Status;

	long code;

	public long getCode() {
		return code;
	}

	public void setCode(long l) {
		this.code = l;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	private List<BusinessMessages> errors;

	public List<BusinessMessages> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<BusinessMessages> errors) {
		this.errors = errors;
	}
}

class BusinessMessages {

	private static final long serialVersionUID = 1L;
	/**
	 * Code
	 */
	private long code;

	/**
	 * Developer Message
	 */
	private String developerMessage;

	/**
	 * Message
	 */
	private String message;

	/**
	 * @return the code
	 */
	public long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(long code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the developerMessage
	 */
	public String getDeveloperMessage() {
		return developerMessage;
	}

	/**
	 * @param developerMessage the developerMessage to set
	 */
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
