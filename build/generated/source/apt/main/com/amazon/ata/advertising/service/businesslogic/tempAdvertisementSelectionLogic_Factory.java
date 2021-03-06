package com.amazon.ata.advertising.service.businesslogic;

import com.amazon.ata.advertising.service.dao.ReadableDao;
import com.amazon.ata.advertising.service.model.AdvertisementContent;
import com.amazon.ata.advertising.service.targeting.TargetingGroup;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class tempAdvertisementSelectionLogic_Factory
    implements Factory<tempAdvertisementSelectionLogic> {
  private final Provider<ReadableDao<String, List<AdvertisementContent>>> contentDaoProvider;

  private final Provider<ReadableDao<String, List<TargetingGroup>>> targetingGroupDaoProvider;

  public tempAdvertisementSelectionLogic_Factory(
      Provider<ReadableDao<String, List<AdvertisementContent>>> contentDaoProvider,
      Provider<ReadableDao<String, List<TargetingGroup>>> targetingGroupDaoProvider) {
    this.contentDaoProvider = contentDaoProvider;
    this.targetingGroupDaoProvider = targetingGroupDaoProvider;
  }

  @Override
  public tempAdvertisementSelectionLogic get() {
    return new tempAdvertisementSelectionLogic(
        contentDaoProvider.get(), targetingGroupDaoProvider.get());
  }

  public static tempAdvertisementSelectionLogic_Factory create(
      Provider<ReadableDao<String, List<AdvertisementContent>>> contentDaoProvider,
      Provider<ReadableDao<String, List<TargetingGroup>>> targetingGroupDaoProvider) {
    return new tempAdvertisementSelectionLogic_Factory(
        contentDaoProvider, targetingGroupDaoProvider);
  }
}
