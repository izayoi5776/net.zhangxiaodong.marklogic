package net.zhangxiaodong.marklogic.launcher.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jdt.internal.debug.ui.IJavaDebugHelpContextIds;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.internal.debug.ui.actions.ControlAccessibleListener;
import org.eclipse.jdt.internal.debug.ui.launcher.LauncherMessages;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.internal.databinding.swt.WidgetListener;
import org.eclipse.swt.events.ModifyListener;
//import org.eclipse.jdt.internal.debug.ui.launcher.AbstractJavaMainTab.WidgetListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
//import org.eclipse.jdt.internal.debug.ui.launcher.AbstractJavaMainTab.WidgetListener;

public class XqueryMainTab extends AbstractLaunchConfigurationTab {

	//Project UI widgets
	protected Text fProjText, fText1, fText2, fText3, fText4, fText5;
	private Button fProjButton;
	private WidgetListener fListener = new WidgetListener(null, null, null, null);
		
	@Override
	public void createControl(Composite parent) {
		Composite projComp = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH); 
		((GridLayout)projComp.getLayout()).verticalSpacing = 0;
		//createProjectEditor(projComp);
		createXqueryEnv(projComp);
		createVerticalSpacer(projComp, 1);
		//createMainTypeEditor(projComp, LauncherMessages.appletlauncher_maintab_mainclasslabel_name);
		createVerticalSpacer(projComp, 1);
		//createAppletViewerControl(projComp);
		setControl(projComp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IJavaDebugHelpContextIds.LAUNCH_CONFIGURATION_DIALOG_APPLET_MAIN_TAB);
	}
	/**
	 * Creates the widgets for specifying a main type.
	 * 
	 * @param parent the parent composite
	 */
	protected void createXqueryEnv(Composite parent) {
		Group group = SWTFactory.createGroup(parent, "&File name", 2, 1, GridData.FILL_HORIZONTAL);

		SWTFactory.createLabel(group, "Run file:", 1);
		fText1 = SWTFactory.createSingleText(group, 1);

		SWTFactory.createLabel(group, "Server:", 1);
		fText2 = SWTFactory.createSingleText(group, 1);
		
		SWTFactory.createLabel(group, "Port:", 1);
		fText3 = SWTFactory.createSingleText(group, 1);
		
		SWTFactory.createLabel(group, "Username:", 1);
		fText4 = SWTFactory.createSingleText(group, 1);

		SWTFactory.createLabel(group, "Password:", 1);
		fText5 = SWTFactory.createSingleText(group, 1);
		//fProjText.addModifyListener((ModifyListener) fListener);
		//ControlAccessibleListener.addListener(fProjText, group.getText());
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			fText2.setText((configuration.getAttribute(IXqyLaunchConfigurationConstants.ATTR_SERVER_NAME, "localhost"))); 
		} catch(CoreException ce) {
			fText2.setText("localhost"); 
		}
		try {
			fText3.setText((configuration.getAttribute(IXqyLaunchConfigurationConstants.ATTR_SERVER_PORT, "8021"))); 
		} catch(CoreException ce) {
			fText3.setText("8021"); 
		}
		try {
			fText4.setText((configuration.getAttribute(IXqyLaunchConfigurationConstants.ATTR_USER_NAME, "admin"))); 
		} catch(CoreException ce) {
			fText4.setText("admin"); 
		}
		try {
			fText5.setText((configuration.getAttribute(IXqyLaunchConfigurationConstants.ATTR_USER_PASS, "admin"))); 
		} catch(CoreException ce) {
			fText5.setText("admin"); 
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IXqyLaunchConfigurationConstants.ATTR_SERVER_NAME, fText2.getText());
		configuration.setAttribute(IXqyLaunchConfigurationConstants.ATTR_SERVER_PORT, fText3.getText());
		configuration.setAttribute(IXqyLaunchConfigurationConstants.ATTR_USER_NAME, fText4.getText());
		configuration.setAttribute(IXqyLaunchConfigurationConstants.ATTR_USER_PASS, fText5.getText());
	}

	@Override
	public String getName() {
		return "test_tab";
	}

}
