package com.dibs.graphql.breakroom.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dibs.graphql.breakroom.dao.VendingMachineDao;
import com.dibs.graphql.breakroom.data.VendingMachine;
import com.dibs.graphql.data.QueryTree;

@Component
public class VendingMachineDaoImpl implements VendingMachineDao {
	
	@Override
	public VendingMachine read(QueryTree query) {
		VendingMachine machine = new VendingMachine();
		machine.setMerchandiseCount(5);
		machine.setServicedBy("Matt");
		machine.setId(Long.valueOf(query.getParamValue(VendingMachine.ID_PROPERTY)));
		
		return machine;
	}

	@Override
	public List<VendingMachine> filter(QueryTree query) {
		List<VendingMachine> machines = new LinkedList<>();
		
		for (int i = 0; i < 3; i++) {
			VendingMachine machine = new VendingMachine();
			machine.setMerchandiseCount(5);
			machine.setId(Long.valueOf(i));
			machine.setServicedBy("Matt");
			machines.add(machine);
		}

		return machines;
	}

}
