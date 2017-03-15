package net.zhangxiaodong.marklogic.launcher.ui;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jdt.internal.debug.ui.IJavaDebugHelpContextIds;
import org.eclipse.jdt.internal.debug.ui.actions.ControlAccessibleListener;
import org.eclipse.jdt.internal.debug.ui.launcher.LauncherMessages;
//import org.eclipse.jdt.internal.debug.ui.launcher.AbstractJavaMainTab.WidgetListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
//import org.eclipse.jdt.internal.debug.ui.launcher.AbstractJavaMainTab.WidgetListener;

public class XqueryMainTab extends AbstractLaunchConfigurationTab {

	//Project UI widgets
	protected Text fProjText;
	private Button fProjButton;
	//private WidgetListener fListener = new WidgetListener();
		
	@Override
	public void createControl(Composite parent) {
		Composite projComp = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH); 
		((GridLayout)projComp.getLayout()).verticalSpacing = 0;
		createProjectEditor(projComp);
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
	protected void createProjectEditor(Composite parent) {
		Group group = SWTFactory.createGroup(parent, LauncherMessages.AbstractJavaMainTab_0, 2, 1, GridData.FILL_HORIZONTAL);
		fProjText = SWTFactory.createSingleText(group, 1);
		//fProjText.addModifyListener(fListener);
		ControlAccessibleListener.addListener(fProjText, group.getText());
		fProjButton = createPushButton(group, LauncherMessages.AbstractJavaMainTab_1, null); 
		//fProjButton.addSelectionListener(fListener);
	}	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "test_tab";
	}

}
