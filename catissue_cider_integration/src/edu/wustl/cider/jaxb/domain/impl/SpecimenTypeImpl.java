//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.09 at 11:16:21 CST 
//


package edu.wustl.cider.jaxb.domain.impl;

public class SpecimenTypeImpl implements edu.wustl.cider.jaxb.domain.SpecimenType, com.sun.xml.bind.JAXBObject, edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallableObject, edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializable, edu.wustl.cider.jaxb.domain.impl.runtime.ValidatableObject
{

    protected java.lang.String _Type;
    protected edu.wustl.cider.jaxb.domain.SpecimenPositionType _SpecimenPosition;
    protected java.lang.String _PathologicalStatus;
    protected edu.wustl.cider.jaxb.domain.SpecimenEventsType _SpecimenEvents;
    protected java.lang.String _ActivityStatus;
    protected boolean has_IsAvailable;
    protected boolean _IsAvailable;
    protected java.lang.String _ClassName;
    protected boolean has_Quantity;
    protected double _Quantity;
    protected boolean has_Id;
    protected long _Id;
    protected edu.wustl.cider.jaxb.domain.SpecimenCharacteristicsType _SpecimenCharacteristics;
    public final static java.lang.Class version = (edu.wustl.cider.jaxb.domain.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (edu.wustl.cider.jaxb.domain.SpecimenType.class);
    }

    public java.lang.String getType() {
        return _Type;
    }

    public void setType(java.lang.String value) {
        _Type = value;
    }

    public edu.wustl.cider.jaxb.domain.SpecimenPositionType getSpecimenPosition() {
        return _SpecimenPosition;
    }

    public void setSpecimenPosition(edu.wustl.cider.jaxb.domain.SpecimenPositionType value) {
        _SpecimenPosition = value;
    }

    public java.lang.String getPathologicalStatus() {
        return _PathologicalStatus;
    }

    public void setPathologicalStatus(java.lang.String value) {
        _PathologicalStatus = value;
    }

    public edu.wustl.cider.jaxb.domain.SpecimenEventsType getSpecimenEvents() {
        return _SpecimenEvents;
    }

    public void setSpecimenEvents(edu.wustl.cider.jaxb.domain.SpecimenEventsType value) {
        _SpecimenEvents = value;
    }

    public java.lang.String getActivityStatus() {
        return _ActivityStatus;
    }

    public void setActivityStatus(java.lang.String value) {
        _ActivityStatus = value;
    }

    public boolean isIsAvailable() {
        return _IsAvailable;
    }

    public void setIsAvailable(boolean value) {
        _IsAvailable = value;
        has_IsAvailable = true;
    }

    public java.lang.String getClassName() {
        return _ClassName;
    }

    public void setClassName(java.lang.String value) {
        _ClassName = value;
    }

    public double getQuantity() {
        return _Quantity;
    }

    public void setQuantity(double value) {
        _Quantity = value;
        has_Quantity = true;
    }

    public long getId() {
        return _Id;
    }

    public void setId(long value) {
        _Id = value;
        has_Id = true;
    }

    public edu.wustl.cider.jaxb.domain.SpecimenCharacteristicsType getSpecimenCharacteristics() {
        return _SpecimenCharacteristics;
    }

    public void setSpecimenCharacteristics(edu.wustl.cider.jaxb.domain.SpecimenCharacteristicsType value) {
        _SpecimenCharacteristics = value;
    }

    public edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingEventHandler createUnmarshaller(edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingContext context) {
        return new edu.wustl.cider.jaxb.domain.impl.SpecimenTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (!has_Quantity) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Quantity"));
        }
        if (!has_Id) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Id"));
        }
        context.startElement("", "Id");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(javax.xml.bind.DatatypeConverter.printLong(((long) _Id)), "Id");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("", "ClassName");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _ClassName), "ClassName");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("", "Type");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _Type), "Type");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("", "PathologicalStatus");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _PathologicalStatus), "PathologicalStatus");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("", "Quantity");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(javax.xml.bind.DatatypeConverter.printDouble(((double) _Quantity)), "Quantity");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("", "ActivityStatus");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _ActivityStatus), "ActivityStatus");
        } catch (java.lang.Exception e) {
            edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        if (has_IsAvailable) {
            context.startElement("", "IsAvailable");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(javax.xml.bind.DatatypeConverter.printBoolean(((boolean) _IsAvailable)), "IsAvailable");
            } catch (java.lang.Exception e) {
                edu.wustl.cider.jaxb.domain.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
        if (_SpecimenCharacteristics!= null) {
            context.startElement("", "SpecimenCharacteristics");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _SpecimenCharacteristics), "SpecimenCharacteristics");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _SpecimenCharacteristics), "SpecimenCharacteristics");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _SpecimenCharacteristics), "SpecimenCharacteristics");
            context.endElement();
        }
        if (_SpecimenPosition!= null) {
            context.startElement("", "SpecimenPosition");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _SpecimenPosition), "SpecimenPosition");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _SpecimenPosition), "SpecimenPosition");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _SpecimenPosition), "SpecimenPosition");
            context.endElement();
        }
        if (_SpecimenEvents!= null) {
            context.startElement("", "SpecimenEvents");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _SpecimenEvents), "SpecimenEvents");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _SpecimenEvents), "SpecimenEvents");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _SpecimenEvents), "SpecimenEvents");
            context.endElement();
        }
    }

    public void serializeAttributes(edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (!has_Quantity) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Quantity"));
        }
        if (!has_Id) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Id"));
        }
    }

    public void serializeURIs(edu.wustl.cider.jaxb.domain.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (!has_Quantity) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Quantity"));
        }
        if (!has_Id) {
            context.reportError(com.sun.xml.bind.serializer.Util.createMissingObjectError(this, "Id"));
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (edu.wustl.cider.jaxb.domain.SpecimenType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000!com.sun.msv.grammar.InterleaveExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom."
+"sun.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/g"
+"rammar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expres"
+"sion\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L"
+"\u0000\u000bexpandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000"
+"ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsr\u0000\'com.sun.msv.grammar.trex.Eleme"
+"ntPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/Name"
+"Class;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignore"
+"UndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003pp\u0000sr\u0000\u001fcom.sun"
+".msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000\u001bcom.sun.msv.g"
+"rammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datat"
+"ype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000"
+"~\u0000\u0003ppsr\u0000!com.sun.msv.datatype.xsd.LongType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com"
+".sun.msv.datatype.xsd.IntegerDerivedType\u0099\u00f1]\u0090&6k\u00be\u0002\u0000\u0001L\u0000\nbaseFa"
+"cetst\u0000)Lcom/sun/msv/datatype/xsd/XSDatatypeImpl;xr\u0000*com.sun."
+"msv.datatype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv"
+".datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatyp"
+"e.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/"
+"String;L\u0000\btypeNameq\u0000~\u0000\u001eL\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype"
+"/xsd/WhiteSpaceProcessor;xpt\u0000 http://www.w3.org/2001/XMLSche"
+"mat\u0000\u0004longsr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Co"
+"llapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProc"
+"essor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u0000*com.sun.msv.datatype.xsd.MaxInclusiveF"
+"acet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000#com.sun.msv.datatype.xsd.RangeFacet\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0001L\u0000\nlimitValuet\u0000\u0012Ljava/lang/Object;xr\u00009com.sun.msv.datat"
+"ype.xsd.DataTypeWithValueConstraintFacet\"\u00a7Ro\u00ca\u00c7\u008aT\u0002\u0000\u0000xr\u0000*com.s"
+"un.msv.datatype.xsd.DataTypeWithFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFi"
+"xedZ\u0000\u0012needValueCheckFlagL\u0000\bbaseTypeq\u0000~\u0000\u001aL\u0000\fconcreteTypet\u0000\'Lc"
+"om/sun/msv/datatype/xsd/ConcreteType;L\u0000\tfacetNameq\u0000~\u0000\u001exq\u0000~\u0000\u001d"
+"ppq\u0000~\u0000%\u0000\u0001sr\u0000*com.sun.msv.datatype.xsd.MinInclusiveFacet\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\'ppq\u0000~\u0000%\u0000\u0000sr\u0000$com.sun.msv.datatype.xsd.IntegerTyp"
+"e\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0019q\u0000~\u0000!t\u0000\u0007integerq\u0000~\u0000%sr\u0000,com.sun.msv.dataty"
+"pe.xsd.FractionDigitsFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\u0005scalexr\u0000;com.sun.msv"
+".datatype.xsd.DataTypeWithLexicalConstraintFacetT\u0090\u001c>\u001azb\u00ea\u0002\u0000\u0000x"
+"q\u0000~\u0000*ppq\u0000~\u0000%\u0001\u0000sr\u0000#com.sun.msv.datatype.xsd.NumberType\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001bq\u0000~\u0000!t\u0000\u0007decimalq\u0000~\u0000%q\u0000~\u00006t\u0000\u000efractionDigits\u0000\u0000\u0000\u0000q\u0000~\u0000"
+"0t\u0000\fminInclusivesr\u0000\u000ejava.lang.Long;\u008b\u00e4\u0090\u00cc\u008f#\u00df\u0002\u0000\u0001J\u0000\u0005valuexr\u0000\u0010jav"
+"a.lang.Number\u0086\u00ac\u0095\u001d\u000b\u0094\u00e0\u008b\u0002\u0000\u0000xp\u0080\u0000\u0000\u0000\u0000\u0000\u0000\u0000q\u0000~\u00000t\u0000\fmaxInclusivesq\u0000~\u0000:"
+"\u007f\u00ff\u00ff\u00ff\u00ff\u00ff\u00ff\u00ffsr\u00000com.sun.msv.grammar.Expression$NullSetExpression"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000"
+"\u0002L\u0000\tlocalNameq\u0000~\u0000\u001eL\u0000\fnamespaceURIq\u0000~\u0000\u001expq\u0000~\u0000\"q\u0000~\u0000!sr\u0000\u001dcom.su"
+"n.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.sun.msv.gr"
+"ammar.AttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\u000fxq\u0000"
+"~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\u0014ppsr\u0000\"c"
+"om.sun.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001bq\u0000~\u0000!t\u0000\u0005QN"
+"ameq\u0000~\u0000%q\u0000~\u0000@sq\u0000~\u0000Aq\u0000~\u0000Lq\u0000~\u0000!sr\u0000#com.sun.msv.grammar.SimpleN"
+"ameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001eL\u0000\fnamespaceURIq\u0000~\u0000\u001exr\u0000\u001d"
+"com.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://w"
+"ww.w3.org/2001/XMLSchema-instancesr\u00000com.sun.msv.grammar.Exp"
+"ression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000G\u0001psq\u0000~\u0000Nt\u0000\u0002I"
+"dt\u0000\u0000sq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\u0012ppsq\u0000~\u0000\u0014ppsr\u0000#com.sun.msv.datatype.xsd.St"
+"ringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxq\u0000~\u0000\u001bq\u0000~\u0000!t\u0000\u0006stringsr\u00005c"
+"om.sun.msv.datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0000xq\u0000~\u0000$\u0001q\u0000~\u0000@sq\u0000~\u0000Aq\u0000~\u0000^q\u0000~\u0000!sq\u0000~\u0000Cppsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000"
+"Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\tClassNameq\u0000~\u0000Xsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\u0012ppq\u0000~\u0000[sq\u0000~\u0000Cpps"
+"q\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u0004Typeq\u0000~\u0000Xsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\u0012p"
+"pq\u0000~\u0000[sq\u0000~\u0000Cppsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u0012Pathologic"
+"alStatusq\u0000~\u0000Xsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\u0012ppsq\u0000~\u0000\u0014ppsr\u0000#com.sun.msv.dataty"
+"pe.xsd.DoubleType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000+com.sun.msv.datatype.xsd.Flo"
+"atingNumberType\u00fc\u00e3\u00b6\u0087\u008c\u00a8|\u00e0\u0002\u0000\u0000xq\u0000~\u0000\u001bq\u0000~\u0000!t\u0000\u0006doubleq\u0000~\u0000%q\u0000~\u0000@sq\u0000~"
+"\u0000Aq\u0000~\u0000xq\u0000~\u0000!sq\u0000~\u0000Cppsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\bQuan"
+"tityq\u0000~\u0000Xsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000\u0012ppq\u0000~\u0000[sq\u0000~\u0000Cppsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000"
+"Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u000eActivityStatusq\u0000~\u0000Xsq\u0000~\u0000Cppsq\u0000~\u0000\u000eq\u0000~\u0000Hp\u0000sq\u0000~\u0000"
+"\u0012ppsq\u0000~\u0000\u0014ppsr\u0000$com.sun.msv.datatype.xsd.BooleanType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002"
+"\u0000\u0000xq\u0000~\u0000\u001bq\u0000~\u0000!t\u0000\u0007booleanq\u0000~\u0000%q\u0000~\u0000@sq\u0000~\u0000Aq\u0000~\u0000\u008aq\u0000~\u0000!sq\u0000~\u0000Cppsq\u0000"
+"~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u000bIsAvailableq\u0000~\u0000Xq\u0000~\u0000Tsq\u0000~\u0000C"
+"ppsq\u0000~\u0000\u000eq\u0000~\u0000Hp\u0000sq\u0000~\u0000\u0012ppsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000Cppsr\u0000 com.sun.msv.gram"
+"mar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003q\u0000~\u0000Hpsq\u0000~\u0000Eq\u0000~\u0000Hpsr\u00002com.sun.msv"
+".grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000~\u0000"
+"Upsr\u0000 com.sun.msv.grammar.AnyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000Oq\u0000~\u0000T"
+"sq\u0000~\u0000Nt\u00007edu.wustl.cider.jaxb.domain.SpecimenCharacteristics"
+"Typet\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000Cppsq"
+"\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u0017SpecimenCharacteristicsq\u0000~"
+"\u0000Xq\u0000~\u0000Tsq\u0000~\u0000Cppsq\u0000~\u0000\u000eq\u0000~\u0000Hp\u0000sq\u0000~\u0000\u0012ppsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000Cppsq\u0000~\u0000\u0095q"
+"\u0000~\u0000Hpsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000\u009aq\u0000~\u0000\u009cq\u0000~\u0000Tsq\u0000~\u0000Nt\u00000edu.wustl.cider.jax"
+"b.domain.SpecimenPositionTypeq\u0000~\u0000\u009fsq\u0000~\u0000Cppsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq"
+"\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u0010SpecimenPositionq\u0000~\u0000Xq\u0000~\u0000Tsq\u0000~\u0000Cppsq\u0000~\u0000\u000eq\u0000"
+"~\u0000Hp\u0000sq\u0000~\u0000\u0012ppsq\u0000~\u0000\u000epp\u0000sq\u0000~\u0000Cppsq\u0000~\u0000\u0095q\u0000~\u0000Hpsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000\u009aq"
+"\u0000~\u0000\u009cq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000.edu.wustl.cider.jaxb.domain.SpecimenEvents"
+"Typeq\u0000~\u0000\u009fsq\u0000~\u0000Cppsq\u0000~\u0000Eq\u0000~\u0000Hpq\u0000~\u0000Iq\u0000~\u0000Pq\u0000~\u0000Tsq\u0000~\u0000Nt\u0000\u000eSpecime"
+"nEventsq\u0000~\u0000Xq\u0000~\u0000Tsr\u0000\"com.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/ExpressionPool$Clos"
+"edHash;xpsr\u0000-com.sun.msv.grammar.ExpressionPool$ClosedHash\u00d7j"
+"\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/gr"
+"ammar/ExpressionPool;xp\u0000\u0000\u0000\'\u0001pq\u0000~\u0000\fq\u0000~\u0000\u0084q\u0000~\u0000\u0094q\u0000~\u0000\u00a8q\u0000~\u0000\u00b5q\u0000~\u0000\u0090q"
+"\u0000~\u0000\u00a4q\u0000~\u0000\u00b1q\u0000~\u0000\u0097q\u0000~\u0000\u00a9q\u0000~\u0000\u00b6q\u0000~\u0000\rq\u0000~\u0000\tq\u0000~\u0000\u0005q\u0000~\u0000\u0092q\u0000~\u0000\u00a6q\u0000~\u0000\u00b3q\u0000~\u0000Zq"
+"\u0000~\u0000gq\u0000~\u0000mq\u0000~\u0000\u007fq\u0000~\u0000\u0006q\u0000~\u0000\u0086q\u0000~\u0000\nq\u0000~\u0000sq\u0000~\u0000\u0007q\u0000~\u0000\bq\u0000~\u0000\u000bq\u0000~\u0000\u0013q\u0000~\u0000Dq"
+"\u0000~\u0000bq\u0000~\u0000hq\u0000~\u0000nq\u0000~\u0000zq\u0000~\u0000\u0080q\u0000~\u0000\u008cq\u0000~\u0000\u00a0q\u0000~\u0000\u00adq\u0000~\u0000\u00bax"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends edu.wustl.cider.jaxb.domain.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingContext context) {
            super(context, "---------------------");
        }

        protected Unmarshaller(edu.wustl.cider.jaxb.domain.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return edu.wustl.cider.jaxb.domain.impl.SpecimenTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  15 :
                        if (("CollectionEvent" == ___local)&&("" == ___uri)) {
                            _SpecimenEvents = ((edu.wustl.cider.jaxb.domain.impl.SpecimenEventsTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.SpecimenEventsTypeImpl.class), 16, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        break;
                    case  3 :
                        if (("StorageContainer" == ___local)&&("" == ___uri)) {
                            _SpecimenPosition = ((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl.class), 4, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        _SpecimenPosition = ((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl.class), 4, ___uri, ___local, ___qname, __atts));
                        return ;
                    case  0 :
                        if (("SpecimenEvents" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 15;
                            return ;
                        }
                        if (("SpecimenPosition" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 3;
                            return ;
                        }
                        if (("SpecimenCharacteristics" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 17;
                            return ;
                        }
                        if (("IsAvailable" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 7;
                            return ;
                        }
                        if (("ActivityStatus" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        if (("Quantity" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 11;
                            return ;
                        }
                        if (("PathologicalStatus" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 19;
                            return ;
                        }
                        if (("Type" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 9;
                            return ;
                        }
                        if (("ClassName" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 13;
                            return ;
                        }
                        if (("Id" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 5;
                            return ;
                        }
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  17 :
                        if (("TissueSite" == ___local)&&("" == ___uri)) {
                            _SpecimenCharacteristics = ((edu.wustl.cider.jaxb.domain.impl.SpecimenCharacteristicsTypeImpl) spawnChildFromEnterElement((edu.wustl.cider.jaxb.domain.impl.SpecimenCharacteristicsTypeImpl.class), 18, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        break;
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
                    case  3 :
                        _SpecimenPosition = ((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl) spawnChildFromLeaveElement((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl.class), 4, ___uri, ___local, ___qname));
                        return ;
                    case  18 :
                        if (("SpecimenCharacteristics" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  20 :
                        if (("PathologicalStatus" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  8 :
                        if (("IsAvailable" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  0 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  10 :
                        if (("Type" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  6 :
                        if (("Id" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  2 :
                        if (("ActivityStatus" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  14 :
                        if (("ClassName" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  12 :
                        if (("Quantity" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  4 :
                        if (("SpecimenPosition" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 0;
                            return ;
                        }
                        break;
                    case  16 :
                        if (("SpecimenEvents" == ___local)&&("" == ___uri)) {
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
                    case  3 :
                        _SpecimenPosition = ((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl) spawnChildFromEnterAttribute((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl.class), 4, ___uri, ___local, ___qname));
                        return ;
                    case  0 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
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
                    case  3 :
                        _SpecimenPosition = ((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl) spawnChildFromLeaveAttribute((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl.class), 4, ___uri, ___local, ___qname));
                        return ;
                    case  0 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
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
                        case  3 :
                            _SpecimenPosition = ((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl) spawnChildFromText((edu.wustl.cider.jaxb.domain.impl.SpecimenPositionTypeImpl.class), 4, value));
                            return ;
                        case  1 :
                            eatText1(value);
                            state = 2;
                            return ;
                        case  11 :
                            eatText2(value);
                            state = 12;
                            return ;
                        case  19 :
                            eatText3(value);
                            state = 20;
                            return ;
                        case  7 :
                            eatText4(value);
                            state = 8;
                            return ;
                        case  0 :
                            revertToParentFromText(value);
                            return ;
                        case  5 :
                            eatText5(value);
                            state = 6;
                            return ;
                        case  9 :
                            eatText6(value);
                            state = 10;
                            return ;
                        case  13 :
                            eatText7(value);
                            state = 14;
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
                _ActivityStatus = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Quantity = javax.xml.bind.DatatypeConverter.parseDouble(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_Quantity = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText3(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _PathologicalStatus = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText4(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _IsAvailable = javax.xml.bind.DatatypeConverter.parseBoolean(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_IsAvailable = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText5(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Id = javax.xml.bind.DatatypeConverter.parseLong(com.sun.xml.bind.WhiteSpaceProcessor.collapse(value));
                has_Id = true;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText6(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Type = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText7(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _ClassName = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
