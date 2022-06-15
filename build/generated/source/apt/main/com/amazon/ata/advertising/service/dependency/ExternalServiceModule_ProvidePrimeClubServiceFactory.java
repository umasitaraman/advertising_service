package com.amazon.ata.advertising.service.dependency;

import com.amazon.ataprimeclubservicelambda.service.ATAPrimeClubService;
import com.amazonaws.auth.AWSCredentialsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ExternalServiceModule_ProvidePrimeClubServiceFactory
    implements Factory<ATAPrimeClubService> {
  private final ExternalServiceModule module;

  private final Provider<AWSCredentialsProvider> credentialsProvider;

  public ExternalServiceModule_ProvidePrimeClubServiceFactory(
      ExternalServiceModule module, Provider<AWSCredentialsProvider> credentialsProvider) {
    this.module = module;
    this.credentialsProvider = credentialsProvider;
  }

  @Override
  public ATAPrimeClubService get() {
    return Preconditions.checkNotNull(
        module.providePrimeClubService(credentialsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ExternalServiceModule_ProvidePrimeClubServiceFactory create(
      ExternalServiceModule module, Provider<AWSCredentialsProvider> credentialsProvider) {
    return new ExternalServiceModule_ProvidePrimeClubServiceFactory(module, credentialsProvider);
  }

  public static ATAPrimeClubService proxyProvidePrimeClubService(
      ExternalServiceModule instance, AWSCredentialsProvider credentialsProvider) {
    return Preconditions.checkNotNull(
        instance.providePrimeClubService(credentialsProvider),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
