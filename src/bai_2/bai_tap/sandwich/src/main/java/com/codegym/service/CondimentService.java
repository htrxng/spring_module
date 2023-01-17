package com.codegym.service;

import com.codegym.model.Condiment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondimentService implements ICondimentService {
    static List<Condiment> condimentList = new ArrayList<>();

    static {
        Condiment potato = new Condiment(1,"Potato","https://www.tastingtable.com/img/gallery/the-trick-that-will-keep-your-potatoes-from-turning-brown/intro-1648573931.jpg");
        Condiment lettuce = new Condiment(2,"Lettuce","https://www.togotshipchandler.com/image/cache/catalog/the%202020/Vegetable/16-Best-Benefits-Of-Lettuce-For-Skin-Hair-And-Health-720x810.jpg");
        Condiment mustard = new Condiment(3,"Mustard","https://static.onecms.io/wp-content/uploads/sites/23/2020/04/30/homemade-mustard-2000.jpg");
        Condiment sprouts = new Condiment(4,"Sprouts","https://www.masalaherb.com/wp-content/uploads/2018/07/How-to-sprout-mung-beans-gog.jpg");
        condimentList.add(potato);
        condimentList.add(lettuce);
        condimentList.add(mustard);
        condimentList.add(sprouts);
    }

    @Override
    public List<Condiment> getCondimentList() {
        return condimentList;
    }
}
