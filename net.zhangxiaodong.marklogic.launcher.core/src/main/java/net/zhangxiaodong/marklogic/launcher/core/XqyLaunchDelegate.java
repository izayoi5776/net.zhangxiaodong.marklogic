package net.zhangxiaodong.marklogic.launcher.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

public class XqyLaunchDelegate extends JavaLaunchDelegate implements ILaunchConfigurationDelegate {

	
	@Override
	public void launch(ILaunchConfiguration configuration, 
	    String mode, 
	    ILaunch launch, 
	    IProgressMonitor monitor) throws CoreException {
			System.out.print("test");
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
				return true;
	}
}
