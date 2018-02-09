package soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    GeoIP geoIP=new GeoIPService().getGeoIPServiceSoap12().getGeoIP("83.6.135.108");
//    System.out.println(geoIP.getCountryCode());
        assertEquals(geoIP.getCountryCode(),"POL");
  }
}
