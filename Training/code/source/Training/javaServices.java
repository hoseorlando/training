package Training;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void demoDocJavaServices (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(demoDocJavaServices)>> ---
		// @sigtype java 3.5
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String PONumber = "";
		String SenderID = "";
		String Description = "";
			// demoDoc
			IData	demoDoc = IDataUtil.getIData( pipelineCursor, "demoDoc" );
			if ( demoDoc != null)
			{
				IDataCursor demoDocCursor = demoDoc.getCursor();
						PONumber = IDataUtil.getString( demoDocCursor, "PONumber" );
						SenderID = IDataUtil.getString( demoDocCursor, "SenderID" );
		
					// i.items
					IData[]	items = IDataUtil.getIDataArray( demoDocCursor, "items" );
					if ( items != null)
					{
						for ( int i = 0; i < items.length; i++ )
						{
							IDataCursor itemsCursor = items[i].getCursor();
									Description = IDataUtil.getString( itemsCursor, "Description" );
								String	Quantity = IDataUtil.getString( itemsCursor, "Quantity" );
							itemsCursor.destroy();
						}
					}
				demoDocCursor.destroy();
			}
		pipelineCursor.destroy();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		
		// outDemoDoc
		IData	outDemoDoc = IDataFactory.create();
		IDataCursor outDemoDocCursor = outDemoDoc.getCursor();
		IDataUtil.put( outDemoDocCursor, "PONumber", PONumber );
		
		// outDemoDoc.items
		IData[]	items_1 = new IData[1];
		items_1[0] = IDataFactory.create();
		IDataCursor items_1Cursor = items_1[0].getCursor();
		IDataUtil.put( items_1Cursor, "Description", Description );
		items_1Cursor.destroy();
		IDataUtil.put( outDemoDocCursor, "items", items_1 );
		outDemoDocCursor.destroy();
		IDataUtil.put( pipelineCursor_1, "outDemoDoc", outDemoDoc );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void myFirstJavaServices (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(myFirstJavaServices)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
		pipelineCursor.destroy();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outputString", inputString );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void mySecondJavaServices (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(mySecondJavaServices)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		IDataMap idm= new IDataMap(pipeline);
		//pipeline input
		String inputString= idm.getAsNonEmptyString("inputString");
		
		//pipeline output
		idm.put("outPutString", inputString);
		// --- <<IS-END>> ---

                
	}
}

