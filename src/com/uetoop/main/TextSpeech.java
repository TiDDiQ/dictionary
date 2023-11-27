package com.uetoop.main;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TextSpeech {
    private String word;

    public void textToSpeech(String word) {
        try {
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();

            // Speaks the given text until the queue is empty.
            synthesizer.speakPlainText(word, null);

            // Wait for the synthesis to complete
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
