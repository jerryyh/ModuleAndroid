/**
 * 
 */
package com.example.jerry.comment_data.bean;



/** 
 * <!-- begin-UML-doc -->
 * 弹出页面返回对象
 * <!-- end-UML-doc -->
 * @author 20003180
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PopupPage extends IBaseResp {
	/** 
	 * <!-- begin-UML-doc -->
	 * 背景图
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String backgroundImage;

	/** 
	 * @return the backgroundImage
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getBackgroundImage() {
		// begin-user-code
		return backgroundImage;
		// end-user-code
	}

	/** 
	 * @param backgroundImage the backgroundImage to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setBackgroundImage(String backgroundImage) {
		// begin-user-code
		this.backgroundImage = backgroundImage;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * 功能按钮名称
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String actionButtonTitle;

	/** 
	 * @return the actionButtonTitle
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getActionButtonTitle() {
		// begin-user-code
		return actionButtonTitle;
		// end-user-code
	}

	/** 
	 * @param actionButtonTitle the actionButtonTitle to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setActionButtonTitle(String actionButtonTitle) {
		// begin-user-code
		this.actionButtonTitle = actionButtonTitle;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * 功能按钮颜色
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String actionButtonColor;

	/** 
	 * @return the actionButtonColor
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getActionButtonColor() {
		// begin-user-code
		return actionButtonColor;
		// end-user-code
	}

	/** 
	 * @param actionButtonColor the actionButtonColor to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setActionButtonColor(String actionButtonColor) {
		// begin-user-code
		this.actionButtonColor = actionButtonColor;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * 功能跳转url
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String actionUrl;

	/** 
	 * @return the actionUrl
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getActionUrl() {
		// begin-user-code
		return actionUrl;
		// end-user-code
	}

	/** 
	 * @param actionUrl the actionUrl to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setActionUrl(String actionUrl) {
		// begin-user-code
		this.actionUrl = actionUrl;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * 是否需要强制登录 
	 * 0 否
	 * 1 是
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int needLogin = 0;

	/** 
	 * @return the needLogin
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getNeedLogin() {
		// begin-user-code
		return needLogin;
		// end-user-code
	}

	/** 
	 * @param needLogin the needLogin to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNeedLogin(int needLogin) {
		// begin-user-code
		this.needLogin = needLogin;
		// end-user-code
	}

	/**
	 * 是否需要弹消息权限弹窗
	 * 0 否
	 * 1 是
	 */
	private int openNotification = 0;

	public int getOpenNotification() {
		return openNotification;
	}

	public void setOpenNotification(int openNotification) {
		this.openNotification = openNotification;
	}


}