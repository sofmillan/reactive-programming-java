package com.sec01.assignment;

import com.utils.Util;

public class Lec09Assignment {
    public static void main(String[] args) {
        System.out.println("READ -----------");
        FileService.read("file01.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        System.out.println("DELETE -----------");
        FileService.delete("file03.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());


        System.out.println("WRITE -----------");
        FileService.write("file03.txt", "This is file 3")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
