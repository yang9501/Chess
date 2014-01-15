//import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class ConnectableTest {
	Server server;
	Client client;
	Packet testPacket;
	Game game;
	
	@Before
	public void setUp() {
		server = mock(Server.class);
		client = mock(Client.class);
		
		server.run();
		client.run();
		
		game = mock(Game.class);
	}
	
	
	@Test
	public void testServerSendPacket() {
		testPacket = new Packet(null, false ,false , false, false, false, false, false);
		server.sendPacket(testPacket);
		verify(server).sendPacket(testPacket);
	}

	@Test
	public void testClientSendPacket() {
		testPacket = new Packet(null, false ,false , false, false, false, false, false);
		client.sendPacket(testPacket);
		verify(client).sendPacket(testPacket);
	}
	
	@Test
	public void testServerHandlePacket() {
		testPacket = new Packet(null, false ,false , false, false, false, false, false);
		server.handlePacket(testPacket);
		verify(server).handlePacket(testPacket);
	}
	
	@Test
	public void testClientHandlePacket() {
		testPacket = new Packet(null, false ,false , false, false, false, false, false);
		client.handlePacket(testPacket);
		verify(client).handlePacket(testPacket);
	}
	
	@Test
	public void testServerCloseConnections() throws IOException {
		server.closeConnections();
		verify(server).closeConnections();
	}
	
	@Test
	public void testClientCloseConnections() throws IOException {
		client.closeConnections();
		verify(client).closeConnections();
	}
}
