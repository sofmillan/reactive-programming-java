package sec02;

import common.Util;
import sec02.assignment.FileServiceImpl;

public class Lec12Assignment {
    public static void main(String[] args) {
        var fileService = new FileServiceImpl();

        fileService.write("file.txt", "Test file")
                        .subscribe(Util.subcriber());

        fileService.read("file.txt")
                .subscribe(Util.subcriber());
    }
}
