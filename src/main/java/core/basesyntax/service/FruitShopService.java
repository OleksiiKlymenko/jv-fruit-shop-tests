package core.basesyntax.service;

import core.basesyntax.fruitscontent.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void processOfOperations(List<FruitTransaction> parsedData);
}
