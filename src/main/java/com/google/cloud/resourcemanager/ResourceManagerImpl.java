/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.resourcemanager;

import static com.google.cloud.RetryHelper.runWithRetries;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.gax.paging.Page;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.Policy;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.Tuple;
import com.google.cloud.resourcemanager.spi.v1beta1.ResourceManagerRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class ResourceManagerImpl extends BaseService<ResourceManagerOptions>
    implements ResourceManager {

  private final ResourceManagerRpc resourceManagerRpc;

  ResourceManagerImpl(ResourceManagerOptions options) {
    super(options);
    resourceManagerRpc = options.getResourceManagerRpcV1Beta1();
  }

  @Override
  public Project create(final ProjectInfo project) {
    try {
      return Project.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.Project>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.Project call() {
                  return resourceManagerRpc.create(project.toPb());
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public void delete(final String projectId) {
    try {
      runWithRetries(
          new Callable<Void>() {
            @Override
            public Void call() {
              resourceManagerRpc.delete(projectId);
              return null;
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public Project get(final String projectId, ProjectGetOption... options) {
    final Map<ResourceManagerRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.cloudresourcemanager.model.Project answer =
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.Project>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.Project call() {
                  return resourceManagerRpc.get(projectId, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Project.fromPb(this, answer);
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  private static class ProjectPageFetcher implements NextPageFetcher<Project> {

    private static final long serialVersionUID = 2158209410430566961L;
    private final Map<ResourceManagerRpc.Option, ?> requestOptions;
    private final ResourceManagerOptions serviceOptions;

    ProjectPageFetcher(
        ResourceManagerOptions serviceOptions,
        String cursor,
        Map<ResourceManagerRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(ResourceManagerRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Project> getNextPage() {
      return listProjects(serviceOptions, requestOptions);
    }
  }

  @Override
  public Page<Project> list(ProjectListOption... options) {
    return listProjects(getOptions(), optionMap(options));
  }

  private static Page<Project> listProjects(
      final ResourceManagerOptions serviceOptions,
      final Map<ResourceManagerRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> result =
          runWithRetries(
              new Callable<
                  Tuple<
                      String,
                      Iterable<com.google.api.services.cloudresourcemanager.model.Project>>>() {
                @Override
                public Tuple<
                        String,
                        Iterable<com.google.api.services.cloudresourcemanager.model.Project>>
                    call() {
                  return serviceOptions.getResourceManagerRpcV1Beta1().list(optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.x();
      Iterable<Project> projects =
          result.y() == null
              ? ImmutableList.<Project>of()
              : Iterables.transform(
                  result.y(),
                  new Function<
                      com.google.api.services.cloudresourcemanager.model.Project, Project>() {
                    @Override
                    public Project apply(
                        com.google.api.services.cloudresourcemanager.model.Project projectPb) {
                      return new Project(
                          serviceOptions.getService(),
                          new ProjectInfo.BuilderImpl(ProjectInfo.fromPb(projectPb)));
                    }
                  });
      return new PageImpl<>(
          new ProjectPageFetcher(serviceOptions, cursor, optionsMap), cursor, projects);
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public Project replace(final ProjectInfo newProject) {
    try {
      return Project.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.Project>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.Project call() {
                  return resourceManagerRpc.replace(newProject.toPb());
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public void undelete(final String projectId) {
    try {
      runWithRetries(
          new Callable<Void>() {
            @Override
            public Void call() {
              resourceManagerRpc.undelete(projectId);
              return null;
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public Policy getPolicy(final String projectId) {
    try {
      com.google.api.services.cloudresourcemanager.model.Policy answer =
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.Policy>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.Policy call() {
                  return resourceManagerRpc.getPolicy(projectId);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : PolicyMarshaller.INSTANCE.fromPb(answer);
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public Policy replacePolicy(final String projectId, final Policy newPolicy) {
    try {
      return PolicyMarshaller.INSTANCE.fromPb(
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.Policy>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.Policy call() {
                  return resourceManagerRpc.replacePolicy(
                      projectId, PolicyMarshaller.INSTANCE.toPb(newPolicy));
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public List<Boolean> testPermissions(final String projectId, final List<String> permissions) {
    try {
      return runWithRetries(
          new Callable<List<Boolean>>() {
            @Override
            public List<Boolean> call() {
              return resourceManagerRpc.testPermissions(projectId, permissions);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public Map<String, Boolean> testOrgPermissions(
      final String resource, final List<String> permissions) {
    try {
      return runWithRetries(
          new Callable<Map<String, Boolean>>() {
            @Override
            public Map<String, Boolean> call() throws IOException {
              return resourceManagerRpc.testOrgPermissions(resource, permissions);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public void clearOrgPolicy(final String resource, final OrgPolicyInfo orgPolicy) {
    try {
      runWithRetries(
          new Callable<Void>() {
            @Override
            public Void call() {
              resourceManagerRpc.clearOrgPolicy(resource, orgPolicy.toPb());
              return null;
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public OrgPolicy getEffectiveOrgPolicy(final String resource, final String constraint) {
    try {
      return OrgPolicy.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.OrgPolicy>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.OrgPolicy call() {
                  return resourceManagerRpc.getEffectiveOrgPolicy(resource, constraint);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public OrgPolicy getOrgPolicy(final String resource, final String constraint) {
    try {
      return OrgPolicy.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.OrgPolicy>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.OrgPolicy call() {
                  return resourceManagerRpc.getOrgPolicy(resource, constraint);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  private static class ConstraintPageFetcher implements NextPageFetcher<Constraint> {

    private static final long serialVersionUID = 2158209410430566961L;
    private final String resource;
    private final Map<ResourceManagerRpc.Option, ?> requestOptions;
    private final ResourceManagerOptions serviceOptions;

    ConstraintPageFetcher(
        String resource,
        ResourceManagerOptions serviceOptions,
        String cursor,
        Map<ResourceManagerRpc.Option, ?> optionMap) {
      this.resource = resource;
      this.requestOptions =
          PageImpl.nextRequestOptions(ResourceManagerRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Constraint> getNextPage() {
      return listAvailableOrgPolicyConstraints(resource, serviceOptions, requestOptions);
    }
  }

  @Override
  public Page<Constraint> listAvailableOrgPolicyConstraints(
      String resource, ListOption... options) {
    return listAvailableOrgPolicyConstraints(resource, getOptions(), optionMap(options));
  }

  private static Page<Constraint> listAvailableOrgPolicyConstraints(
      final String resource,
      final ResourceManagerOptions serviceOptions,
      final Map<ResourceManagerRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Constraint>>
          result =
              runWithRetries(
                  new Callable<
                      Tuple<
                          String,
                          Iterable<
                              com.google.api.services.cloudresourcemanager.model.Constraint>>>() {
                    @Override
                    public Tuple<
                            String,
                            Iterable<com.google.api.services.cloudresourcemanager.model.Constraint>>
                        call() {
                      return serviceOptions
                          .getResourceManagerRpcV1Beta1()
                          .listAvailableOrgPolicyConstraints(resource, optionsMap);
                    }
                  },
                  serviceOptions.getRetrySettings(),
                  EXCEPTION_HANDLER,
                  serviceOptions.getClock());
      String cursor = result.x();
      Iterable<Constraint> constraints =
          result.y() == null
              ? ImmutableList.<Constraint>of()
              : Iterables.transform(
                  result.y(),
                  new Function<
                      com.google.api.services.cloudresourcemanager.model.Constraint, Constraint>() {
                    @Override
                    public Constraint apply(
                        com.google.api.services.cloudresourcemanager.model.Constraint
                            constraintPb) {
                      return new Constraint(
                          serviceOptions.getService(),
                          new ConstraintInfo.BuilderImpl(ConstraintInfo.fromPb(constraintPb)));
                    }
                  });
      return new PageImpl<>(
          new ConstraintPageFetcher(resource, serviceOptions, cursor, optionsMap),
          cursor,
          constraints);
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  private static class OrgPolicyPageFetcher implements NextPageFetcher<OrgPolicy> {

    private static final long serialVersionUID = 2158209410430566961L;
    private final String resource;
    private final Map<ResourceManagerRpc.Option, ?> requestOptions;
    private final ResourceManagerOptions serviceOptions;

    OrgPolicyPageFetcher(
        String resource,
        ResourceManagerOptions serviceOptions,
        String cursor,
        Map<ResourceManagerRpc.Option, ?> optionMap) {
      this.resource = resource;
      this.requestOptions =
          PageImpl.nextRequestOptions(ResourceManagerRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<OrgPolicy> getNextPage() {
      return listOrgPolicies(resource, serviceOptions, requestOptions);
    }
  }

  @Override
  public Page<OrgPolicy> listOrgPolicies(final String resource, ListOption... options) {
    return listOrgPolicies(resource, getOptions(), optionMap(options));
  }

  private static Page<OrgPolicy> listOrgPolicies(
      final String resource,
      final ResourceManagerOptions serviceOptions,
      final Map<ResourceManagerRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.OrgPolicy>> result =
          runWithRetries(
              new Callable<
                  Tuple<
                      String,
                      Iterable<com.google.api.services.cloudresourcemanager.model.OrgPolicy>>>() {
                @Override
                public Tuple<
                        String,
                        Iterable<com.google.api.services.cloudresourcemanager.model.OrgPolicy>>
                    call() {
                  return serviceOptions
                      .getResourceManagerRpcV1Beta1()
                      .listOrgPolicies(resource, optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.x();
      Iterable<OrgPolicy> orgPolicies =
          result.y() == null
              ? ImmutableList.<OrgPolicy>of()
              : Iterables.transform(
                  result.y(),
                  new Function<
                      com.google.api.services.cloudresourcemanager.model.OrgPolicy, OrgPolicy>() {
                    @Override
                    public OrgPolicy apply(
                        com.google.api.services.cloudresourcemanager.model.OrgPolicy orgPolicyPb) {
                      return new OrgPolicy(
                          serviceOptions.getService(),
                          new OrgPolicyInfo.BuilderImpl(OrgPolicyInfo.fromPb(orgPolicyPb)));
                    }
                  });
      return new PageImpl<>(
          new OrgPolicyPageFetcher(resource, serviceOptions, cursor, optionsMap),
          cursor,
          orgPolicies);
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  @Override
  public OrgPolicy replaceOrgPolicy(final String resource, final OrgPolicyInfo orgPolicy) {
    try {
      return OrgPolicy.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.cloudresourcemanager.model.OrgPolicy>() {
                @Override
                public com.google.api.services.cloudresourcemanager.model.OrgPolicy call() {
                  return resourceManagerRpc.replaceOrgPolicy(resource, orgPolicy.toPb());
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException ex) {
      throw ResourceManagerException.translateAndThrow(ex);
    }
  }

  private Map<ResourceManagerRpc.Option, ?> optionMap(Option... options) {
    Map<ResourceManagerRpc.Option, Object> temp = Maps.newEnumMap(ResourceManagerRpc.Option.class);
    for (Option option : options) {
      Object prev = temp.put(option.getRpcOption(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return ImmutableMap.copyOf(temp);
  }
}
