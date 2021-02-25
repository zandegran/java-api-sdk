package com.smartling.api.attachments.v2;

import com.smartling.api.attachments.v2.pto.AttachmentEntitiesPTO;
import com.smartling.api.attachments.v2.pto.AttachmentListFilter;
import com.smartling.api.attachments.v2.pto.AttachmentPTO;
import com.smartling.api.attachments.v2.pto.EntityAttachmentsPTO;
import com.smartling.api.attachments.v2.pto.EntityLinkCommand;
import com.smartling.api.attachments.v2.pto.EntityListCommand;
import com.smartling.api.v2.response.ListResponse;
import com.smartling.api.v2.response.EmptyData;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/attachments-api/v2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AttachmentsApi
{
    @GET
    @Path("/accounts/{accountUid}/{type}/attachments")
    ListResponse<AttachmentEntitiesPTO> listAttachments(@PathParam("accountUid") String accountUid, @PathParam("type") String type, @BeanParam AttachmentListFilter listFilter);

    @PUT
    @Path("/accounts/{accountUid}/{type}")
    ListResponse<EntityAttachmentsPTO> linkAttachments(@PathParam("accountUid") String accountUid, @PathParam("type") String type, EntityLinkCommand command);

    @GET
    @Path("/accounts/{accountUid}/{type}/{entityUid}")
    ListResponse<AttachmentPTO> entityAttachments(@PathParam("accountUid") String accountUid, @PathParam("type") String type, @PathParam("entityUid") String entityUid);

    @POST
    @Path("/accounts/{accountUid}/{type}")
    ListResponse<EntityAttachmentsPTO> bulkEntityAttachments(@PathParam("accountUid") String accountUid, @PathParam("type") String type, EntityListCommand command);

    @DELETE
    @Path("/accounts/{accountUid}/{type}/{entityUid}")
    EmptyData deleteAttachments(@PathParam("accountUid") String accountUid, @PathParam("type") String type, @PathParam("entityUid") String entityUid);

    @DELETE
    @Path("/accounts/{accountUid}/{type}/{entityUid}/attachment/{attachmentUid}")
    EmptyData deleteAttachment(@PathParam("accountUid") String accountUid, @PathParam("type") String type, @PathParam("entityUid") String entityUid, @PathParam("attachmentUid") String attachmentUid);
}
