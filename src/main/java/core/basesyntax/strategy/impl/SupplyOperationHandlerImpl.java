package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.fruitscontent.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruits.get(transaction.getFruit());
        FruitStorage.fruits.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}