//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.09 at 11:16:21 CST 
//


package edu.wustl.cider.jaxb.domain.impl;

public class CollectionProtocolTypeImpl implements edu.wustl.cider.jaxb.domain.CollectionProtocolType, com.sun.xml.bind.JAXBObject, edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallableObject, edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializable, edu.wustl.cider.jaxb.domain.impl.runtime.ValidatableObject
{

    protected java.lang.String _Title;
    protected edu.wustl.cider.jaxb.domain.UserType _PrincipalInvestigator;
    public final static java.lang.Class version = (edu.wustl.cider.jaxb.domain.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (edu.wustl.cider.jaxb.domain.CollectionProtocolType.class);
    }

    public java.lang.String getTitle() {
        return _Title;
    }

    public void setTitle(java.lang.String value) {
        _Title = value;
    }

    public edu.wustl.cider.jaxb.domain.UserType getPrincipalInvestigator() {
        return _PrincipalInvestigator;
    }

    public void setPrincipalInvestigator(edu.wustl.cider.jaxb.domain.UserType value) {
        _PrincipalInvestigator = value;
    }

    public edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingEventHandler createUnmarshaller(edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingContext context) {
        return new edu.wustl.cider.jaxb.domain.impl.CollectionProtocolTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "PrincipalInvestigator");
        context.childAsURIs(((com.sun.xml.bind.JAXBObject) _PrincipalInvestigator), "PrincipalInvestigator");
        context.endNamespaceDecls();
        context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _PrincipalInvestigator), "PrincipalInvestigator");
        context.endAttributes();
        context.childAsBody(((com.sun.xml.bind.JAXBObject) _PrincipalInvestigator), "PrincipalInvestigator");
        context.endElement();
        context.startElement("", "Title");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _Title), "Title");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
    }

    public void serializeAttributes(edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (edu.wustl.cider.jaxb.domain.CollectionProtocolType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000!com.sun.msv.grammar.InterleaveExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom."
+"sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/g"
+"rammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expres"
+"sion\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L"
+"\u0000\u000bexpandedExpq\u0000~\u0000\u0002xpppsr\u0000\'com.sun.msv.grammar.trex.ElementPa"
+"ttern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClas"
+"s;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUnde"
+"claredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003pp\u0000sr\u0000\u001fcom.sun.msv"
+".grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsq\u0000~\u0000\u0006pp\u0000sr\u0000\u001dcom.sun."
+"msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.sun.msv.gram"
+"mar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z"
+"\u0000\u0005valuexp\u0000psr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000"
+"\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\u0007xq\u0000~\u0000\u0003q\u0000~\u0000\u0013psr\u00002com.sun.msv.gramma"
+"r.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000\u0012\u0001psr\u0000"
+" com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv."
+"grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar.Expres"
+"sion$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000~\u0000\u0018psr\u0000#com.sun.msv"
+".grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang"
+"/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001fxq\u0000~\u0000\u001at\u0000$edu.wustl.cider.jaxb.do"
+"main.UserTypet\u0000+http://java.sun.com/jaxb/xjc/dummy-elementss"
+"q\u0000~\u0000\rppsq\u0000~\u0000\u0014q\u0000~\u0000\u0013psr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
+"\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004nam"
+"et\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0003ppsr\u0000\"com.sun.msv.dat"
+"atype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.B"
+"uiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.Conc"
+"reteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeIm"
+"pl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUriq\u0000~\u0000\u001fL\u0000\btypeNameq\u0000~\u0000\u001fL\u0000\nwhiteSpa"
+"cet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000 http"
+"://www.w3.org/2001/XMLSchemat\u0000\u0005QNamesr\u00005com.sun.msv.datatype"
+".xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv."
+"datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv"
+".grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003ppsr\u0000\u001b"
+"com.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001fL\u0000\fna"
+"mespaceURIq\u0000~\u0000\u001fxpq\u0000~\u00000q\u0000~\u0000/sq\u0000~\u0000\u001et\u0000\u0004typet\u0000)http://www.w3.org"
+"/2001/XMLSchema-instanceq\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u0000\u0015PrincipalInvestigatort"
+"\u0000\u0000sq\u0000~\u0000\u0006pp\u0000sq\u0000~\u0000\nppsq\u0000~\u0000%ppsr\u0000#com.sun.msv.datatype.xsd.Stri"
+"ngType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxq\u0000~\u0000*q\u0000~\u0000/t\u0000\u0006stringsr\u00005com"
+".sun.msv.datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
+"\u0000xq\u0000~\u00002\u0001q\u0000~\u00005sq\u0000~\u00006q\u0000~\u0000Cq\u0000~\u0000/sq\u0000~\u0000\rppsq\u0000~\u0000\u0014q\u0000~\u0000\u0013pq\u0000~\u0000(q\u0000~\u00008q"
+"\u0000~\u0000\u001dsq\u0000~\u0000\u001et\u0000\u0005Titleq\u0000~\u0000=sr\u0000\"com.sun.msv.grammar.ExpressionPoo"
+"l\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPoo"
+"l$ClosedHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$Closed"
+"Hash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000\u0006parentt\u0000$Lcom/sun/"
+"msv/grammar/ExpressionPool;xp\u0000\u0000\u0000\u0007\u0001pq\u0000~\u0000\u000eq\u0000~\u0000\u0005q\u0000~\u0000\u0011q\u0000~\u0000\u000bq\u0000~\u0000?"
+"q\u0000~\u0000#q\u0000~\u0000Gx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends edu.wustl.cider.jaxb.domain.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingContext context) {
            super(context, "-----");
        }

        protected Unmarshaller(edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return edu.wustl.cider.jaxb.domain.impl.CollectionProtocolTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        if (("Title" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 3;
                            return ;
                        }
                        if (("PrincipalInvestigator" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  1 :
                        if (("Email" == ___local)&&("" == ___uri)) {
                            _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("FirstName" == ___local)&&("" == ___uri)) {
                            _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("LastName" == ___local)&&("" == ___uri)) {
                            _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname, __atts));
                        return ;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  4 :
                        if (("Title" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  1 :
                        _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromLeaveElement((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname));
                        return ;
                    case  2 :
                        if (("PrincipalInvestigator" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  1 :
                        _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromEnterAttribute((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname));
                        return ;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  1 :
                        _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromLeaveAttribute((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, ___uri, ___local, ___qname));
                        return ;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  0 :
                            revertToParentFromText(value);
                            return ;
                        case  1 :
                            _PrincipalInvestigator = ((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl) spawnChildFromText((edu.wustl.cider.jaxb.domain.impl.UserTypeImpl.class), 2, value));
                            return ;
                        case  3 :
                            eatText1(value);
                            state = 4;
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Title = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
