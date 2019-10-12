package org.carlspring.strongbox.domain;

import org.carlspring.strongbox.util.annotations.PypiMetadataKey;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PypiPackageInfo
{

    @NotNull
    @PypiMetadataKey(name = "Metadata-Version")
    private PypiPackageInfo.SupportedMetadataVersionEnum metadataVersion;

    @NotBlank
    @Pattern(regexp = "^([A-Z0-9]|[A-Z0-9][A-Z0-9._-]*[A-Z0-9])$", flags = Pattern.Flag.CASE_INSENSITIVE)
    @PypiMetadataKey(name = "Name")
    private String name;

    //version format validation done with PypiVersionValidator
    @NotBlank
    @PypiMetadataKey(name = "Version")
    private String version;

    @PypiMetadataKey(name = "Summary")
    private String summary;

    @PypiMetadataKey(name = "Home-page")
    private String homePage;

    @PypiMetadataKey(name = "Author")
    private String author;

    @PypiMetadataKey(name = "Author-email")
    private String authorEmail;

    @PypiMetadataKey(name = "License")
    private String license;

    @PypiMetadataKey(name = "Description-Content-Type")
    private String descriptionContentType;

    @PypiMetadataKey(name = "Description")
    private String description;

    @PypiMetadataKey(name = "Platform")
    private String platform;


    public PypiPackageInfo()
    {
    }

    public SupportedMetadataVersionEnum getMetadataVersion()
    {
        return metadataVersion;
    }

    public String getName()
    {
        return name;
    }

    public String getVersion()
    {
        return version;
    }

    public String getSummary()
    {
        return summary;
    }

    public String getHomePage()
    {
        return homePage;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getAuthorEmail()
    {
        return authorEmail;
    }

    public String getLicense()
    {
        return license;
    }

    public String getDescriptionContentType()
    {
        return descriptionContentType;
    }

    public String getDescription()
    {
        return description;
    }

    public String getPlatform()
    {
        return platform;
    }

    public enum SupportedMetadataVersionEnum
    {
        VERSION_1_0("1.0"),
        VERSION_1_1("1.1"),
        VERSION_1_2("1.2"),
        VERSION_2_1("2.1");

        private String version;

        public String getVersionString()
        {
            return version;
        }

        public static SupportedMetadataVersionEnum getVersionEnum(String version)
                throws IllegalArgumentException
        {
            for (SupportedMetadataVersionEnum metadataVersionEnum : SupportedMetadataVersionEnum.values())
            {
                if (metadataVersionEnum.getVersionString().equals(version))
                {
                    return metadataVersionEnum;
                }
            }
            throw new IllegalArgumentException("Unsupported Metadata version: " + version);
        }

        SupportedMetadataVersionEnum(String version)
        {
            this.version = version;
        }
    }
}
