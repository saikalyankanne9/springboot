package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"page",
"pages",
"per_page",
"total",
"id",
"iso2Code",
"name",
"region",
"AdminRegion",
"incomeLevel",
"lendingType",
"capitalCity",
"longitude",
"latitude"
})
public class ResponseObject {

@JsonProperty("page")
private String page;
@JsonProperty("pages")
private String pages;
@JsonProperty("per_page")
private String perPage;
@JsonProperty("total")
private String total;
@JsonProperty("id")
private String id;
@JsonProperty("iso2Code")
private String iso2Code;
@JsonProperty("name")
private String name;
@JsonProperty("region")
private Region region;
@JsonProperty("AdminRegion")
private AdminRegion AdminRegion;
@JsonProperty("incomeLevel")
private IncomeLevel incomeLevel;
@JsonProperty("lendingType")
private LendingType lendingType;
@JsonProperty("capitalCity")
private String capitalCity;
@JsonProperty("longitude")
private String longitude;
@JsonProperty("latitude")
private String latitude;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("page")
public String getPage() {
return page;
}

@JsonProperty("page")
public void setPage(String page) {
this.page = page;
}

@JsonProperty("pages")
public String getPages() {
return pages;
}

@JsonProperty("pages")
public void setPages(String pages) {
this.pages = pages;
}

@JsonProperty("per_page")
public String getPerPage() {
return perPage;
}

@JsonProperty("per_page")
public void setPerPage(String perPage) {
this.perPage = perPage;
}

@JsonProperty("total")
public String getTotal() {
return total;
}

@JsonProperty("total")
public void setTotal(String total) {
this.total = total;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("iso2Code")
public String getIso2Code() {
return iso2Code;
}

@JsonProperty("iso2Code")
public void setIso2Code(String iso2Code) {
this.iso2Code = iso2Code;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("region")
public Region getRegion() {
return region;
}

@JsonProperty("region")
public void setRegion(Region region) {
this.region = region;
}

@JsonProperty("AdminRegion")
public AdminRegion getAdminRegion() {
return AdminRegion;
}

@JsonProperty("AdminRegion")
public void setAdminRegion(AdminRegion AdminRegion) {
this.AdminRegion = AdminRegion;
}

@JsonProperty("incomeLevel")
public IncomeLevel getIncomeLevel() {
return incomeLevel;
}

@JsonProperty("incomeLevel")
public void setIncomeLevel(IncomeLevel incomeLevel) {
this.incomeLevel = incomeLevel;
}

@JsonProperty("lendingType")
public LendingType getLendingType() {
return lendingType;
}

@JsonProperty("lendingType")
public void setLendingType(LendingType lendingType) {
this.lendingType = lendingType;
}

@JsonProperty("capitalCity")
public String getCapitalCity() {
return capitalCity;
}

@JsonProperty("capitalCity")
public void setCapitalCity(String capitalCity) {
this.capitalCity = capitalCity;
}

@JsonProperty("longitude")
public String getLongitude() {
return longitude;
}

@JsonProperty("longitude")
public void setLongitude(String longitude) {
this.longitude = longitude;
}

@JsonProperty("latitude")
public String getLatitude() {
return latitude;
}

@JsonProperty("latitude")
public void setLatitude(String latitude) {
this.latitude = latitude;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}