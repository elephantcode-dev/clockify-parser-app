package dev.elephantcode.clockifychabreparserapp.chabre;

import dev.elephantcode.clockifychabreparserapp.output.Printer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChabreTimeEntryConsolePrinter implements Printer {

    @Override
    public void print(String line) {
        System.out.println(line);
    }
}
