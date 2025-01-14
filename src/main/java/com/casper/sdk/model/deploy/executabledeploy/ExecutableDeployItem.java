package com.casper.sdk.model.deploy.executabledeploy;

import com.casper.sdk.model.clvalue.serde.CasperSerializableObject;
import com.casper.sdk.model.deploy.NamedArg;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

/**
 * Abstract Executable Deploy Item containing the runtime args of the contract.
 * It can be any of the following types:
 *
 * @author Alexandre Carvalho
 * @author Andre Bertolace
 * @see ModuleBytes
 * @see StoredContractByHash
 * @see StoredContractByName
 * @see StoredVersionedContractByHash
 * @see StoredVersionedContractByName
 * @see Transfer
 * @since 0.0.1
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({@JsonSubTypes.Type(value = ModuleBytes.class, name = "ModuleBytes"),
        @JsonSubTypes.Type(value = StoredContractByHash.class, name = "StoredContractByHash"),
        @JsonSubTypes.Type(value = StoredContractByName.class, name = "StoredContractByName"),
        @JsonSubTypes.Type(value = StoredVersionedContractByHash.class, name = "StoredVersionedContractByHash"),
        @JsonSubTypes.Type(value = StoredVersionedContractByName.class, name = "StoredVersionedContractByName"),
        @JsonSubTypes.Type(value = Transfer.class, name = "Transfer")})
public interface ExecutableDeployItem extends CasperSerializableObject {

    List<NamedArg<?>> getArgs();

    @JsonIgnore
    byte getOrder();
}
