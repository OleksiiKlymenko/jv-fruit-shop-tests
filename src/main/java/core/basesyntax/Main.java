//package core.basesyntax;
//
//import core.basesyntax.fruitscontent.FruitTransaction;
//import core.basesyntax.service.FruitShopService;
//import core.basesyntax.service.ParserOperationService;
//import core.basesyntax.service.ReaderService;
//import core.basesyntax.service.ReportService;
//import core.basesyntax.service.WriterService;
//import core.basesyntax.service.impl.FruitShopServiceImpl;
//import core.basesyntax.service.impl.ParserOperationServiceImpl;
//import core.basesyntax.service.impl.ReaderServiceImpl;
//import core.basesyntax.service.impl.ReportServiceImpl;
//import core.basesyntax.service.impl.WriterServiceImpl;
//import core.basesyntax.strategy.OperationHandler;
//import core.basesyntax.strategy.OperationStrategy;
//import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
//import core.basesyntax.strategy.impl.OperationStrategyImpl;
//import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
//import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
//import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Main {
//    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
//    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
//
//    public static void main(String[] args) {
//
//        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
//        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
//                new BalanceOperationHandlerImpl());
//        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
//                new PurchaseOperationHandlerImpl());
//        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
//                new SupplyOperationHandlerImpl());
//        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
//                new ReturnOperationHandlerImpl());
//
//        ReaderService readerService = new ReaderServiceImpl();
//        List<String> inputData = readerService.readFromFile(INPUT_FILE_PATH);
//
//        ParserOperationService transactionService = new ParserOperationServiceImpl();
//        List<FruitTransaction> fruitTransactions =
//                transactionService.parseContentForOperations(inputData);
//
//        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
//        FruitShopService transactionHandler = new FruitShopServiceImpl(operationStrategy);
//        transactionHandler.processOfOperations(fruitTransactions);
//
//        ReportService reportService = new ReportServiceImpl();
//        String report = reportService.report();
//        System.out.println(report);
//
//        WriterService writerService = new WriterServiceImpl();
//        writerService.writeToFile(report, OUTPUT_FILE_PATH);
//    }
//}