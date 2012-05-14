/*
Created by: Narendra Rajput
Contact   : bknarendra2008@gmail.com

Use the program the way you like. You have all the permission to play with it or screw it
with only one request plzz don't remove the comment from the file
*/
public interface Ideone_Service_v1Service extends javax.xml.rpc.Service {
    public java.lang.String getIdeone_Service_v1PortAddress();

    public Ideone_Service_v1Port_PortType getIdeone_Service_v1Port() throws javax.xml.rpc.ServiceException;

    public Ideone_Service_v1Port_PortType getIdeone_Service_v1Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
