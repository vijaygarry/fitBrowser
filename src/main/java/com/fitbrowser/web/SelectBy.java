package com.fitbrowser.web;

/**
 * Possible options to locate the element on html document.
 * 
 * @author Vijay Garothaya
 * @version 1.0 Jan 6, 2015
 */
public enum SelectBy {

	ID("id"), NAME("name"), CLASS_NAME("class"), TAG_NAME("tag"), LINK_TEXT(
			"link"), PARTIAL_LINK_TEXT("partlink"), CSS_SELECTOR("css"), XPATH(
			"xpath");

	private String selectorType;


	private SelectBy ( String aSelectorType ) {
		this.selectorType = aSelectorType;
	}


	public String getSelectorType () {
		return this.selectorType;
	}


	public static SelectBy getSelectBy ( String aSelectType ) {
		if ( aSelectType == null ) {
			return null;
		}
		for ( SelectBy selectBy : values() ) {
			if ( selectBy.getSelectorType().equalsIgnoreCase( aSelectType ) ) {
				return selectBy;
			}
		}

		return null;
	}


	public int getPrefixLength () {
		return this.selectorType.length() + 1;
	}

	public static SelectBy getSelectorType ( String aElementSelector ) {
		if ( aElementSelector == null ) {
			return null;
		}
		String selectorString = aElementSelector.toLowerCase();
		for ( SelectBy selectBy : values() ) {
			if ( selectorString.startsWith( selectBy.selectorType + ":" ) ) {
				return selectBy;
			}
		}
		return null;
	}
}
