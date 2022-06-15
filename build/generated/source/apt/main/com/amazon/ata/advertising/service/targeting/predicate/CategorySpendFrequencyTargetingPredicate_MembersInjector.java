package com.amazon.ata.advertising.service.targeting.predicate;

import com.amazon.ata.advertising.service.dao.ReadableDao;
import com.amazon.ata.advertising.service.model.RequestContext;
import com.amazon.ata.customerservice.Spend;
import dagger.MembersInjector;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CategorySpendFrequencyTargetingPredicate_MembersInjector
    implements MembersInjector<CategorySpendFrequencyTargetingPredicate> {
  private final Provider<ReadableDao<RequestContext, Map<String, Spend>>> spendDaoProvider;

  public CategorySpendFrequencyTargetingPredicate_MembersInjector(
      Provider<ReadableDao<RequestContext, Map<String, Spend>>> spendDaoProvider) {
    this.spendDaoProvider = spendDaoProvider;
  }

  public static MembersInjector<CategorySpendFrequencyTargetingPredicate> create(
      Provider<ReadableDao<RequestContext, Map<String, Spend>>> spendDaoProvider) {
    return new CategorySpendFrequencyTargetingPredicate_MembersInjector(spendDaoProvider);
  }

  @Override
  public void injectMembers(CategorySpendFrequencyTargetingPredicate instance) {
    injectSpendDao(instance, spendDaoProvider.get());
  }

  public static void injectSpendDao(
      CategorySpendFrequencyTargetingPredicate instance,
      ReadableDao<RequestContext, Map<String, Spend>> spendDao) {
    instance.spendDao = spendDao;
  }
}
