package lotto.controller;

import java.util.List;
import lotto.Lottos;
import lotto.model.LottoGenerator;
import lotto.model.LottoNumberGenerator;
import lotto.utils.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    NumberGenerator numberGenerator = new LottoNumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    LottoGenerator lottoGenerator = new LottoGenerator();
    private Lottos lottos;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private int buyPrice;

    public void execute() {
        set();
        start();
        announceWinning(winningNumber, bonusNumber, buyPrice);
    }

    public void set() {
        outputView.printInsertBuyPrice();
        buyPrice = inputView.insertBuyPrice();
        lottos = new Lottos(lottoGenerator.generate(buyPrice, numberGenerator));
    }

    public void start() {
        lottos.getLotto();
        outputView.printInsertWinningNumber();
        winningNumber = inputView.insertWinningNumber();
        outputView.printInsertBonusNumber();
        bonusNumber = inputView.insertBonusNumber();
    }

    public void announceWinning(List<Integer> winningNumber, int bonusNumber, int buyPrice) {
        lottos.announceWinning(winningNumber, bonusNumber, buyPrice);
    }
}
