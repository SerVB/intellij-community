/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.plugins.github.api;

import com.google.gson.annotations.SerializedName;
import com.intellij.tasks.impl.gson.Mandatory;
import com.intellij.tasks.impl.gson.RestModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@RestModel
@SuppressWarnings("UnusedDeclaration")
class GithubRepoRaw {
  private Long id;
  @Mandatory private String name;
  private String fullName;
  @Mandatory private String description;

  @SerializedName("private")
  @Mandatory private Boolean isPrivate;
  @SerializedName("fork")
  @Mandatory private Boolean isFork;

  private String url;
  @Mandatory private String htmlUrl;
  @Mandatory private String cloneUrl;
  private String gitUrl;
  private String sshUrl;
  private String svnUrl;
  private String mirrorUrl;

  private String homepage;
  private String language;
  private Integer size;

  private Integer forks;
  private Integer forksCount;
  private Integer watchers;
  private Integer watchersCount;
  private Integer openIssues;
  private Integer openIssuesCount;

  private String masterBranch;
  private String defaultBranch;

  private Boolean hasIssues;
  private Boolean hasWiki;
  private Boolean hasDownloads;

  @Mandatory private GithubUserRaw owner;
  private GithubUserRaw organization;

  private Date pushedAt;
  private Date createdAt;
  private Date updatedAt;

  @NotNull
  public String getName() {
    return name;
  }

  @NotNull
  public String getDescription() {
    return description;
  }

  public boolean isPrivate() {
    return isPrivate;
  }

  public boolean isFork() {
    return isFork;
  }

  @NotNull
  public String getHtmlUrl() {
    return htmlUrl;
  }

  @NotNull
  public String getCloneUrl() {
    return cloneUrl;
  }

  @Nullable
  public String getDefaultBranch() {
    return defaultBranch;
  }

  @NotNull
  public GithubUserRaw getOwner() {
    return owner;
  }


  @NotNull
  public String getUserName() {
    return getOwner().getLogin();
  }

  @NotNull
  public String getFullName() {
    return getUserName() + "/" + getName();
  }

  @NotNull
  public GithubFullPath getFullPath() {
    return new GithubFullPath(getUserName(), getName());
  }

}
