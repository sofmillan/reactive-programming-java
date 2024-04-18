package com.sec02;

import com.sec02.helper.NameGenerator;
import com.utils.Util;

import java.util.List;

public class Lec07FluxVSList {
    public static void main(String[] args) {
        /*List<String> names = NameGenerator.getNames(5);
        System.out.println(names);*/

        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());
    }
}
