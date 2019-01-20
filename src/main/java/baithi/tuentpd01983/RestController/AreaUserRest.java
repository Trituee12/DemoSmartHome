package baithi.tuentpd01983.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.services.AreaServices;

@RestController
public class AreaUserRest {
	
	@Autowired
	AreaServices areaService;
	
	@GetMapping(value = "/homepage/area/{id}"  )
	public List<Area> areaform( @PathVariable Long id , Area area) {	

		List<Area> list = new ArrayList<Area>();
		for(Area areas : areaService.findAreaByIdUser(id))	{
			list.add(areas);
		System.out.println(areas);
		}
		return list;
	}
}
