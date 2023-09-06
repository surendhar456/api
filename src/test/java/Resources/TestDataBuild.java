package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.addPlace;
import Pojo.location;

public class TestDataBuild {

	
	public  addPlace addPlacePayload() {
		
		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 0");
		p.setLanguage("French-IN");
		p.setWebsite("http://google.com");
		p.setName("surendhar");
		p.setPhone_number("(+91) 983 893 3937")
		;
		List<String> myList = new ArrayList<String>();
		
		myList.add("shoe park");
		myList.add("shop");
		
		
		
		
		p.setTypes(myList);
		location l = new location ()
;
	l.setLat( -38.383494);
	l.setLng(33.427362);
	
	p.setLocation(l);
	return p;
	
	}
}
