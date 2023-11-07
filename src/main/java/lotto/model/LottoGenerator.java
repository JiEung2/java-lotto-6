package lotto.model;

import static lotto.utils.Constants.LOTTO_PRICE_PER_UNIT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.utils.NumberGenerator;

public class LottoGenerator {

    public List<Lotto> generate(int price, NumberGenerator lottoNumberGenerator) {
        int lottoCount = generateLottoCount(price);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generateNumber()))
                .collect(Collectors.toList());
    }

    private int generateLottoCount(int price) {
        return price / LOTTO_PRICE_PER_UNIT;
    }
}