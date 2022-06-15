package com.amazon.ata.advertising.service.targeting;

import com.amazon.ata.advertising.service.model.RequestContext;
import com.amazon.ata.advertising.service.targeting.predicate.TargetingPredicate;
import com.amazon.ata.advertising.service.targeting.predicate.TargetingPredicateResult;
import com.amazon.ata.advertising.service.util.Futures;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.*;

/**
 * Evaluates TargetingPredicates for a given RequestContext.
 */
public class TargetingEvaluator {
    public static final boolean IMPLEMENTED_STREAMS = true;
    public static final boolean IMPLEMENTED_CONCURRENCY = true;
    private final RequestContext requestContext;

    /**
     * Creates an evaluator for targeting predicates.
     * @param requestContext Context that can be used to evaluate the predicates.
     */
    public TargetingEvaluator(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    /**
     * Evaluate a TargetingGroup to determine if all of its TargetingPredicates are TRUE or not for the given
     * RequestContext.
     * @param targetingGroup Targeting group for an advertisement, including TargetingPredicates.
     * @return TRUE if all of the TargetingPredicates evaluate to TRUE against the RequestContext, FALSE otherwise.
     */
    public TargetingPredicateResult evaluate(TargetingGroup targetingGroup)  {
        List<TargetingPredicate> targetingPredicates = targetingGroup.getTargetingPredicates();
        //boolean allTruePredicates = true;

        ExecutorService executor = Executors.newCachedThreadPool();

//        for (TargetingPredicate predicate : targetingPredicates) {
//            TargetingPredicateResult predicateResult = null;
//            try {
//                predicateResult = executor.submit(() -> predicate.evaluate(requestContext)).get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//
//            assert predicateResult != null;
//            if (!predicateResult.isTrue()) {
//                allTruePredicates = false;
//                break;
//            }
//        }
//        executor.shutdown();
//        return allTruePredicates ? TargetingPredicateResult.TRUE :
//                                   TargetingPredicateResult.FALSE;
        boolean allTruePredicates =  targetingPredicates.stream()
                .map(predicate -> executor.submit(() -> predicate.evaluate(requestContext)))
                .allMatch(targetingPredicateResultFuture -> Futures.getUnchecked(targetingPredicateResultFuture).isTrue());

        executor.shutdown();

        return allTruePredicates ? TargetingPredicateResult.TRUE :
                TargetingPredicateResult.FALSE;
    }
}
