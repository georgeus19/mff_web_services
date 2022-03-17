
package custodian;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the custodian package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoveStock_QNAME = new QName("http://custodian/", "RemoveStock");
    private final static QName _RemoveStockResponse_QNAME = new QName("http://custodian/", "RemoveStockResponse");
    private final static QName _StoreStock_QNAME = new QName("http://custodian/", "StoreStock");
    private final static QName _StoreStockResponse_QNAME = new QName("http://custodian/", "StoreStockResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: custodian
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveStock }
     * 
     */
    public RemoveStock createRemoveStock() {
        return new RemoveStock();
    }

    /**
     * Create an instance of {@link RemoveStockResponse }
     * 
     */
    public RemoveStockResponse createRemoveStockResponse() {
        return new RemoveStockResponse();
    }

    /**
     * Create an instance of {@link StoreStock }
     * 
     */
    public StoreStock createStoreStock() {
        return new StoreStock();
    }

    /**
     * Create an instance of {@link StoreStockResponse }
     * 
     */
    public StoreStockResponse createStoreStockResponse() {
        return new StoreStockResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStock }{@code >}
     */
    @XmlElementDecl(namespace = "http://custodian/", name = "RemoveStock")
    public JAXBElement<RemoveStock> createRemoveStock(RemoveStock value) {
        return new JAXBElement<RemoveStock>(_RemoveStock_QNAME, RemoveStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://custodian/", name = "RemoveStockResponse")
    public JAXBElement<RemoveStockResponse> createRemoveStockResponse(RemoveStockResponse value) {
        return new JAXBElement<RemoveStockResponse>(_RemoveStockResponse_QNAME, RemoveStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreStock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StoreStock }{@code >}
     */
    @XmlElementDecl(namespace = "http://custodian/", name = "StoreStock")
    public JAXBElement<StoreStock> createStoreStock(StoreStock value) {
        return new JAXBElement<StoreStock>(_StoreStock_QNAME, StoreStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreStockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StoreStockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://custodian/", name = "StoreStockResponse")
    public JAXBElement<StoreStockResponse> createStoreStockResponse(StoreStockResponse value) {
        return new JAXBElement<StoreStockResponse>(_StoreStockResponse_QNAME, StoreStockResponse.class, null, value);
    }

}
