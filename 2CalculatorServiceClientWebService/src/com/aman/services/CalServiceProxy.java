package com.aman.services;

public class CalServiceProxy implements com.aman.services.CalService {
  private String _endpoint = null;
  private com.aman.services.CalService calService = null;
  
  public CalServiceProxy() {
    _initCalServiceProxy();
  }
  
  public CalServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalServiceProxy();
  }
  
  private void _initCalServiceProxy() {
    try {
      calService = (new com.aman.services.CalServiceServiceLocator()).getCalService();
      if (calService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calService != null)
      ((javax.xml.rpc.Stub)calService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.aman.services.CalService getCalService() {
    if (calService == null)
      _initCalServiceProxy();
    return calService;
  }
  
  public int add(int a, int b) throws java.rmi.RemoteException{
    if (calService == null)
      _initCalServiceProxy();
    return calService.add(a, b);
  }
  
  public int subtract(int a, int b) throws java.rmi.RemoteException{
    if (calService == null)
      _initCalServiceProxy();
    return calService.subtract(a, b);
  }
  
  
}