public class ServiceNotAvailableAtTheMoment extends Exception {

	public ServiceNotAvailableAtTheMoment() {
		if (!CheckedException.isNetworkConnection())
			System.out.println("Your network connection is down");
		if (!CheckedException.isFirewall())
			System.out.println("Your firewall is down");
		if (!CheckedException.isRouter())
			System.out.println("Your router is down");
	}
}