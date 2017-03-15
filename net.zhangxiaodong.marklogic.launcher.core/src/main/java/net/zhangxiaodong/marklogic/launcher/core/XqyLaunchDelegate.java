package net.zhangxiaodong.marklogic.launcher.core;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

import com.marklogic.xcc.ContentSource;
import com.marklogic.xcc.ContentSourceFactory;
import com.marklogic.xcc.Request;
import com.marklogic.xcc.ResultSequence;
import com.marklogic.xcc.Session;
import com.marklogic.xcc.exceptions.RequestException;
import com.marklogic.xcc.exceptions.XccConfigException;

public class XqyLaunchDelegate extends JavaLaunchDelegate implements ILaunchConfigurationDelegate {

	
	@Override
	public void launch(ILaunchConfiguration configuration, 
	    String mode, 
	    ILaunch launch, 
	    IProgressMonitor monitor) throws CoreException {
			System.out.print("test");
			ISourceLocator sl = launch.getSourceLocator();
			try {
				run();
			} catch (XccConfigException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RequestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
				return true;
	}
	
	private void run() throws URISyntaxException, XccConfigException, RequestException{
    	URI uri = new URI("xcc://admin:admin@localhost:8021/");
    	ContentSource contentSource = 
    	          ContentSourceFactory.newContentSource (uri);

    	Session session = contentSource.newSession();
    	Request request = session.newAdhocQuery ("/nodes/node[1 to 10]");
    	ResultSequence rs = session.submitRequest (request);
    	System.out.println (rs.asString());
    	session.close();
	}
	
}
