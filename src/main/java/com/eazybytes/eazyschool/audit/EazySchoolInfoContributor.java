package com.eazybytes.eazyschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EazySchoolInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> eazyMap = new HashMap<>();
        eazyMap.put("App Name", "Eazyschool");
        eazyMap.put("App Description", "Eazy School Web Application for Students and Admin");
        eazyMap.put("App version", "1.0.0");
        eazyMap.put("Contact email", "info@eazyschool.com");
        eazyMap.put("Contact mobile", "+1(21)673 4587");
        builder.withDetail("eazyschool-info", eazyMap);
    }
}
