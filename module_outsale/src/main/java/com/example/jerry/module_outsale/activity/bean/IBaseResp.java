/**
 * 
 */
package com.example.jerry.module_outsale.activity.bean;

/** 
 * <!-- begin-UML-doc -->
 * 返回对象基类
 * <!-- end-UML-doc -->
 * @author 20003180
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class IBaseResp {
	/** 
	 * <!-- begin-UML-doc -->
	 * 0 业务失败   1 业务成功
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int state = 1;

	/** 
	 * @return the state
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getState() {
		// begin-user-code
		return state;
		// end-user-code
	}

	/** 
	 * @param state the state to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setState(int state) {
		// begin-user-code
		this.state = state;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * 错误码 （如果state＝0）
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String errorCode;

	/** 
	 * @return the errorCode
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getErrorCode() {
		// begin-user-code
		return errorCode;
		// end-user-code
	}

	/** 
	 * @param errorCode the errorCode to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setErrorCode(String errorCode) {
		// begin-user-code
		this.errorCode = errorCode;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * 返回消息（正确错误都可能返回信息）
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String msg;

	/** 
	 * @return the msg
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getMsg() {
		// begin-user-code
		return msg;
		// end-user-code
	}

	/** 
	 * @param msg the msg to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setMsg(String msg) {
		// begin-user-code
		this.msg = msg;
		// end-user-code
	}
}