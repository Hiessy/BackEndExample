package org.university.development.domain.feature.client.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import org.university.development.domain.feature.commons.support.CriteriaSupport;

@Component
public class ClientCriteriaSupport
    extends CriteriaSupport {

    @Override
    public List<Order> getAllOrders() {
        List<Order> sortings = new ArrayList<Order>();
        sortings.add(new Order(Sort.Direction.ASC, "name"));
        sortings.add(new Order(Sort.Direction.DESC, "name"));
        sortings.add(new Order(Sort.Direction.ASC, "gender"));
        sortings.add(new Order(Sort.Direction.DESC, "gender"));
        return sortings;
    }

}
