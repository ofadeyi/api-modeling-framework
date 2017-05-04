package org.raml.amf.core;

/**
 * Created by antoniogarrote on 04/05/2017.
 */

import org.raml.amf.core.exceptions.InvalidModelException;
import org.raml.amf.utils.Clojure;

/**
 * Base class for all AMF parsed models, provides methods to inspect and manipulate the model
 */
public abstract class Model {

    static {
        Clojure.require(Clojure.API_MODELING_FRAMEWORK_CORE);
    }

    protected Object rawModel;

    protected Model(Object rawModel) {
        if (rawModel instanceof Exception) {
            throw new InvalidModelException((Exception) rawModel);
        }
        this.rawModel = rawModel;
    }

    /**
     * Returns the raw Clojure data structure for this instance data
     * @return
     */
    public abstract Object clojureModel();
}
