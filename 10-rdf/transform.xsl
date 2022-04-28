<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:variable name="prefix">https://example.org/iana/media-types/</xsl:variable>
   
    <xsl:template match="Person">
    <xsl:variable name="personId">people:<xsl:value-of select="@id"/></xsl:variable>
@prefix rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix schema: &lt;https://schema.org/&gt; .
@prefix gr: &lt;http://purl.org/goodrelations/v1#&gt; .
@prefix people: &lt;http://www.example.org/people/&gt; .
@prefix stocks: &lt;http://www.example.org/stocks/&gt; .

<xsl:value-of select="$personId"/> rdf:type schema:Person .
<xsl:value-of select="$personId"/> schema:givenName "<xsl:value-of select="GivenName"/>"^^xsd:string .
<xsl:value-of select="$personId"/> schema:familyName "<xsl:value-of select="FamilyName"/>"^^xsd:string .

<xsl:for-each select="StoredStocks/Stock">
<xsl:value-of select="$personId"/> gr:owns stocks:<xsl:value-of select="@id"/> .
stocks:<xsl:value-of select="@id"/> a stocks:Stock .
stocks:<xsl:value-of select="@id"/> stocks:of &lt;<xsl:value-of select="Company/@url"/>&gt; .
stocks:<xsl:value-of select="@id"/> gr:name "<xsl:value-of select="Company"/>"@en .

</xsl:for-each>
<xsl:apply-templates/>
   
    </xsl:template>
   
    <xsl:template match="text()"/>
   
</xsl:stylesheet>
