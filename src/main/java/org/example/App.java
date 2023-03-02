package org.example;

import org.example.phrase.controller.PhraseController;
import org.example.system.controller.SystemController;

import java.io.IOException;

public class App {

    public void run() throws IOException {
        System.out.println("== 명언앱 ==");

        SystemController systemController = new SystemController();
        PhraseController phraseController = new PhraseController();
        while (true) {
            System.out.print("명령) ");
            String command = Container.getBufferedReader().readLine();
            Rq rq = new Rq(command);

            switch (rq.getFunction()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    phraseController.write();
                    break;
                case "목록":
                    phraseController.list();
                    break;
                case "삭제":
                    phraseController.remove(rq);
                    break;
                case "수정":
                    phraseController.modify(rq);
                    break;
            }
        }
    }
}
