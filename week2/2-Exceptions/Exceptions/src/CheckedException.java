class CheckedException {
	private static boolean networkConnection;
	private static boolean firewall;
	private static boolean router;

	public CheckedException() {
	}

	public CheckedException(boolean networkConnection, boolean firewall,
			boolean router) {
		CheckedException.networkConnection = networkConnection;
		CheckedException.firewall = firewall;
		CheckedException.router = router;
	}

	public static boolean isNetworkConnection() {
		return networkConnection;
	}

	public void setNetworkConnection(boolean networkConnection) {
		CheckedException.networkConnection = networkConnection;
	}

	public static boolean isFirewall() {
		return firewall;
	}

	public void setFirewall(boolean firewall) {
		CheckedException.firewall = firewall;
	}

	public static boolean isRouter() {
		return router;
	}

	public void setRouter(boolean router) {
		CheckedException.router = router;
	}

	public void useService() throws ServiceNotAvailableAtTheMoment {
		if (networkConnection == false || firewall == false || router == false)
			throw new ServiceNotAvailableAtTheMoment();
	}
}