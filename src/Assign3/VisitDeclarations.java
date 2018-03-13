/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class uses the ASTVisitor to search for nodes of java language type TypeDeclaration (class)
 * and counts the total number of declarations found.
 */

package src.Assign3;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitDeclarations extends ASTVisitor {
	
	String QualName = "";
	
	public VisitDeclarations(String QualName) {
		this.QualName = QualName;
	}
	
	private int num = 0;											//Total number of declarations found.
	
	
	/**
	 * This function searches through he AST given and counts the total number of declarations found
	 * of type class.
	 * 
	 * @param node		The AST to search though.
	 * @return			False, to skip the nodes children.
	 */
	
	public boolean visit(TypeDeclaration node) {
			
		if(node.getName().toString().equals(QualName)){  
			num ++;								
			return true;
		}
		return true; 			// goto children of this node
	}
	

	
	
	public boolean visit(AnnotationTypeDeclaration node) {
		if(node.getName().toString().equals(QualName)){  
			num ++;															//this message and increment the total.
			return true;
		}
		return true;				 // goto children of this node
	}

	public boolean visit(EnumConstantDeclaration node) {
		if(node.getName().toString().equals(QualName)){ 		//When a class node is found print a message
		num ++;													//and increment the total.
		return true;  // skip children of this node
		}
	return true;
}
	
	
	/**
	 * Getter for the total number of declarations found.
	 * 
	 * @return			The total number of declarations found.
	 */
	
	public int getNum() {
		return num;
	}	
}